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
        def array = harvestSolicitations.toArray();
        for(int i = 0; i < array.length; i++){
            HarvestSolicitation res =  array[i]
            if(res.residueGenerator.addressGenerator == withAddress) {
                return true;
            }
        }
        return false;
    }
    def isEmpty(){
        return harvestSolicitations.toArray().length == 0
    }
    def computeData(){
        def residueGeneratorArr = ResidueGenerator.findAll().toArray()
        def array = harvestSolicitations.toArray();
        avgProduction = new double[residueGeneratorArr.length]
        stdProduction = new double[residueGeneratorArr.length]
        isHigher = new boolean[residueGeneratorArr.length]
        names = new String[residueGeneratorArr.length]
        // for now I will use brute force to compute  avg and std of each
        for (int i = 0 ; i< residueGeneratorArr.length;i++){
            double sum = 0
            int counter = 0
            double[] val = new double[monthsBack]
            ResidueGenerator gen = residueGeneratorArr[i]
            for (int j =0; j<array.length;j++){

                HarvestSolicitation res =  array[i]

                if(gen.nameGenerator == res.residueGenerator.nameGenerator) {
                    sum += res.estimatedAmountOfResidue;
                    val[counter] = res.estimatedAmountOfResidue
                    counter++

                }

            }
            avgProduction[i] = sum/counter
            sum = 0;
            for (int j =0; j<counter;j++){
                int dif = val[j] - avgProduction[i]
                sum += dif*dif
            }
            if( counter > 0  && avgProduction[i] > val[counter-1]) isHigher[i] = 0
            else  isHigher[i] = true

            stdProduction[i] = Math.sqrt(sum/counter)
            names[i] = gen.nameGenerator

        }


    }


}
