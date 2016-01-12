package pages
import geb.Page


class HistoricoPage extends Page{

    def titulo = "Create Coleta"
    static url = "/ResS/coleta/create"

    static at = {

        title ==~ titulo
    }

    def fillColetaInfo(){
        $("form").nome = "RU"
        $("form").data_day = "8"
        $("form").data_month = "4"
        $("form").data_year = "2015"
        $("form").volume = 101
        $("form").senha = "123456"

    }

    def selectAdicionarColeta(){
        $("input", name: "create").click()
    }

}

