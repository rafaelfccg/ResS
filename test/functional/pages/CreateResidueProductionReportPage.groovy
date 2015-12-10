package pages

import geb.Page

/**
 * Created by ess on 23/11/15.
 */
class CreateResidueProductionReportPage extends Page{
    def titulo = "http://localhost:8070/generatorProductionReport/create/1"
    static url = "/generatorProductionReport/create/1"

    static at = {
        title ==~ titulo
    }

    def fillPeriod(String period){

        $("input", name: "monthsBack").value(period)
       // $("select", name: "type").

    }

    def clickNewMonthlyReport(){
        $("input[name='Ok']").click()
    }
    //look generator edit page
    def boolean hasEmptyMessage(){

        def emptyField = $('input:empty')

        if(emptyField != null){
            return true
        } else {
            return false
        }
    }
}