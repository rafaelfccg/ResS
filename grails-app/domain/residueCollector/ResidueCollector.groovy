package residueCollector

/**
 * Created by ess on 21/10/15.
 */
class ResidueCollector {

    String email_collector
    String cnpj_collector


    static constraints = {
        email_collector nullable: true, blank: false, unique: true, minSize: 4, maxSize: 40
        cnpj_collector nullable: true, blank: false, unique: true, minSize: 18, maxSize: 18


    }

}
