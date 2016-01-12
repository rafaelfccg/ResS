package pages
import geb.Page

//Modified by Ricardo Barioni

class ColetaListPage extends Page{

    def titulo = "Coleta List"
    static url = "/ResS/coleta/list"


    static at = {
        title ==~ titulo
    }

	def boolean hasErrors(){
		if($(".errors") == null){
			return false
		}else{
			return true
		}
	}
	
}
