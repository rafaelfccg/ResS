package pages

import geb.Page

/**
 * Created by ess on 18/11/15.
 */
class ResidueProductionReportPage extends Page{
    def titulo = "Generator Production Report"
    static url = "ResS/generatorProductionReport/show"

    static at = {
        title ==~ titulo
    }
    def boolean hasEmptyMessage(){

        def emptyField = $('input:empty')

        if(emptyField != null){
            return true
        } else {
            return false
        }
    }
    def clickExportCSV(String name, String path){

    }

}
