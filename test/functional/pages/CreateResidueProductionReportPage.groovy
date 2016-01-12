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

        $("form").period = period

    }

    def fillFields(String type, int period){

        $("select", name:type).find(type)
        $("form").find("field", name:"monthsBack").value(period)

    }

    def clickSubmit() {

        $("submit").click()

    }

    def clickNewMonthlyReport(){
        $("monthReport").click()
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
