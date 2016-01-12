package pages

import geb.Page

/**
 * Created by ess on 23/11/15.
 */
class CreateResidueProductionReportPage extends Page{
    def titulo = "Criar relatorio de producao de residuo"

    static url = "ResS/generatorProductionReport/create"

    static at = {
        title ==~ titulo
    }

    def fillPeriod(String period){

        $("input", name: "monthsBack").value(period)
       // $("select", name: "type").

    }

    def fillFields(String type, int period){

        $("select", name:type).find(type)
        $("form").find("field", name:"monthsBack").value(period)

    }

    def clickSubmit() {

        $("submit").click()

    }

    def clickNewMonthlyReport(){
        $("input", type: "submit").click()
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
