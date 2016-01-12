package generatorProductionReport

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverDirectHTTP
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

    def saveCSV(String name, String path){


    }
}
