package generatorProductionReport

import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

/**
 * Created by ess on 16/11/15.
 */
class GeneratorProductionReport {
    Date creationDate
    int numberOfGenerator


    static hasMany = [harvestSolicitations:HarvestSolicitation]

}
