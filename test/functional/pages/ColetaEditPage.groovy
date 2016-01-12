package pages
import geb.Page

class ColetaEditPage extends Page{

    def titulo = "Edit Coleta"
    static url = "/ResS/coleta/edit/1"

    static at = {
        title ==~ titulo
    }
    def fillVolume(int vol){
        $("form").volume = vol
    }
    def fillOtherFields() {
        $("form").nome = "RU"
        $("form").data_day = "8"
        $("form").data_month = "4"
        $("form").data_year = "2015"
    }
    def submitChanges(){
        $("input", name: "_action_update").click()
    }

}