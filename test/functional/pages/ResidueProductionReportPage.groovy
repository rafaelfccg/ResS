package pages

import geb.Page

/**
 * Created by ess on 18/11/15.
 */
class ResidueProductionReportPage extends Page{
    def titulo = "Generator Production Report"
    static url = "/generatorProductionReport/show/1"

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
