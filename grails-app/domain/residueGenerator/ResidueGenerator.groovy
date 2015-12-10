package residueGenerator

class ResidueGenerator {
    //#if ($RegisterAResidueGenerator)
    String username
    String password
    //#end
    String nameGenerator // nome do estabelecimento
    String type// tipo de estabelecimento
    String addressGenerator // endere�o do gerador n�o confundir...

    String cnpj
    int averageDailyMeals
    int averageMonthlyMeals

    boolean hasActiveHarvest
    HarvestSolicitation harvestSolicitation

    static  hasOne = [harvestSolicitation:HarvestSolicitation]

    static constraints = {
        //#if ($RegisterAResidueGenerator)
        username  nullable:true, blank: false, unique: true, minSize: 4, maxSize:30
        password  nullable:true, blank: false, minSize:8, maxSize:30

        //#end
        nameGenerator nullable:true,blank:true // no caso de ser ecoponto pode n�o ter nome
        type inList: ["Restaurante","Cantina","Ecoponto"], nullable:false, blank:false
        addressGenerator blank: false, nullable: false, maxSize: 40, unique: true
        averageDailyMeals  nullable: false, min: 0,blank:false
        averageMonthlyMeals  nullable: false, min: 0,blank:false
        hasActiveHarvest nullable:false
        harvestSolicitation nullable:true
        //#if ($EditAccountsCnpj)
        cnpj blank:false, nullable:false, minSize: 14, maxSize: 14, matches: "[0-9]+"
        //#end
    }

    String toString(){
        if(!nameGenerator){
            return addressGenerator
        }else{
            return nameGenerator
        }
    }
}