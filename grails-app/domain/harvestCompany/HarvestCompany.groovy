package harvestCompany

/**
 * Created by danie_000 on 6/22/2015.
 */
class HarvestCompany {
    int id
    String name;

    static constraints = {
        id nullable:false,unique:true,blank:false
        name nullable: false, blank: false
    }
}
