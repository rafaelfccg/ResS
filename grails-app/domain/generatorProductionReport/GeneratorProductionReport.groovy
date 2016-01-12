package generatorProductionReport

import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

/**
 * Created by ess on 16/11/15.
 */
class GeneratorProductionReport {
    Date creationDate
    int numberOfGenerators
    int monthsBack
    String type
    double[] avgProduction
    double[] stdProduction
    boolean[] isHigher
    String[] names

    static hasMany = [harvestSolicitations:HarvestSolicitation]

    def hasGenerator(String withAddress){
        if (harvestSolicitations != null) {
            def array = ResidueGenerator.findAll().toArray();
//            print("checking")
//            print(array.length)
            for (int i = 0; i < array.length; i++) {
                ResidueGenerator res = array[i]
//                print(res.residueGenerator.addressGenerator)
                if (res.addressGenerator == withAddress) {
                    return true;
                }
            }
        }
        return false;
    }
    def isEmpty(){
        if (harvestSolicitations != null) {
            return harvestSolicitations.toArray().length == 0
        }
        return true
    }

    def computeData() {
        if(type == "ano") {

            computeAnnualData()

        }else {
            def residueGeneratorArr = ResidueGenerator.findAll().toArray()
            def array = harvestSolicitations.toArray();
            avgProduction = new double[1]
            stdProduction = new double[1]
            isHigher = new boolean[1]
            names = new String[1]
            names[0] = "No collection registered"
            // for now I will use brute force to compute  avg and std of each
            if (array.length > 0) {
                avgProduction = new double[residueGeneratorArr.length]
                stdProduction = new double[residueGeneratorArr.length]
                isHigher = new boolean[residueGeneratorArr.length]
                names = new String[residueGeneratorArr.length]
                for (int i = 0; i < residueGeneratorArr.length; i++) {
                    double sum = 0
                    int counter = 0
                    double[] val = new double[monthsBack]
                    Date lastDate = ((HarvestSolicitation) array[0]).confirmationDate

                    ResidueGenerator gen = residueGeneratorArr[i]
                    for (int j = 0; j < array.length; j++) {

                        HarvestSolicitation res = array[j]

                        if (gen.nameGenerator == res.residueGenerator.nameGenerator) {
                            print(gen.nameGenerator)
                            sum += res.estimatedAmountOfResidue;
                            val[counter] += res.estimatedAmountOfResidue
                            if (res.confirmationDate.month > lastDate.month) {
                                counter++
                                lastDate = res.confirmationDate
                            }
                        }

                    }
                    counter++
                    avgProduction[i] = sum / counter
                    sum = 0;
                    for (int j = 0; j < counter; j++) {
                        int dif = val[j] - avgProduction[i]
                        sum += dif * dif
                    }
                    if (counter > 0 && avgProduction[i] > val[counter - 1]) isHigher[i] = 0
                    else isHigher[i] = true

                    stdProduction[i] = Math.sqrt(sum / counter)
                    names[i] = gen.nameGenerator

                }


            }
        }
    }

    def computeAnnualData() {

        def harvests = harvestSolicitations.findAll{h -> h.status == 'Confirmada'}

        def now = Calendar.instance
        def finalYear = now[Calendar.YEAR] - monthsBack

        def limit = new Date()
        limit.setYear(finalYear)

        def periodHarvests = harvests.findAll{p -> p.confirmationDate.before(limit)}
        def finalPeriod = periodHarvests.findAll{f -> f.confirmationDate[MONTH] == creationDate[MONTH]}

        def residueGenerators = []

        for(int i=0; i<finalPeriod.size(); i++) {

            residueGenerators.add(finalPeriod[i].residueGenerator.nameGenerator)

        }

        def uniqueResidueGenerators = residueGenerators.unique()

        numberOfGenerators = uniqueResidueGenerators.size()

        avgProduction = new double[numberOfGenerators]
        stdProduction = new double[numberOfGenerators]
        isHigher = new boolean[numberOfGenerators]

        for (int k = 0; k< numberOfGenerators ;k++) {

            double sum = 0
            int counter = 0
            double[] val = new double[monthsBack]

            ResidueGenerator rGenerator = uniqueResidueGenerators[k]

            for (int j = 0; j<finalPeriod.size(); j++) {

                HarvestSolicitation hSol = finalPeriod[j]

                if(rGenerator.nameGenerator == hSol.residueGenerator.nameGenerator) {

                    sum += hSol.estimatedAmountOfResidue;
                    val[counter] = hSol.estimatedAmountOfResidue
                    counter++

                }

            }

            avgProduction[k] = sum/counter

            sum = 0;

            for (int l =0; l<counter;l++){
                int dif = val[l] - avgProduction[k]
                sum += dif*dif
            }

            if( counter > 0  && avgProduction[k] > val[counter-1]) isHigher[k] = false
            else  isHigher[k] = true

            stdProduction[k] = Math.sqrt(sum/counter)
            names[k] = rGenerator.nameGenerator

        }

    }

    def saveCSV(String name, String path){

    }


}
