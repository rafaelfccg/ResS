package pages

import geb.Page

/**
 * Created by ess on 18/11/15.
 */
class ResidueProductionReportPage extends Page{
    def titulo = "http://localhost:8070/generatorProductionReport/show/1"
    static url = "/generatorProductionReport/show/1"

    static at = {
        title ==~ titulo
    }

}
