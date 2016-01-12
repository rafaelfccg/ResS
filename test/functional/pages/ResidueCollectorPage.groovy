package pages

import geb.Page

/**
 * Created by ess on 05/10/15.
 */
class ResidueCollectorPage extends Page {

    def titulo = "Create Residue Collector"
    def url = "/ResS/residueCollector/create"

    static at = {

        title ==~ titulo
    }


    def fillCollectorDetails(LinkedHashMap collector){

        $("form").email = collector.email
        $("form").cnpj = collector.cnpj
    }


    def selectCreateCollector(){
        $("input", name: "create").click()
    }
}
