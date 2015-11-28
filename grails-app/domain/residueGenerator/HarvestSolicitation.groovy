package residueGenerator

class HarvestSolicitation {

    int harvesterId;
    int generatorId;
    String status;
    int estimatedAmountOfResidue;
    Date solicitationDate;
    Date confirmationDate;
    ResidueGenerator residueGenerator;

    static belongsTo = [residueGenerator : ResidueGenerator]

    static constraints = {
        harvesterId nullable:false,blank:false,unique:true
        generatorId nullable:false,blank:false,unique:true
        status nullable:false,blank:false
        solicitationDate nullable:false,blank:false
        confirmationDate nullable:true,blank:false
        estimatedAmountOfResidue nullable:false,blank:false
    }
}
