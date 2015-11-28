package pages
import geb.Page

class ColetaDeletePage extends Page{

    def titulo = "Show Coleta"
    static url = "/ResS/coleta/show/1"


    static at = {
        title ==~ titulo
    }



}
