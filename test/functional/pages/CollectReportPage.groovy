package pages

import geb.Page

class CollectReportPage extends Page{

    def titulo = "Relatorio de coletas"
    static url = "ResS/coleta/genReport"

    static at = {
        title == titulo
    }


    def selectTodayDate(){
        $("input", name: "date1_day").click()
        $("input", name: "date2_day").click()
    }

    def gerar(){
        $("input", name: "Gerar Relatório").click()
    }

    def submit(){
        $("input", name: "Ok ").click()
    }

}
