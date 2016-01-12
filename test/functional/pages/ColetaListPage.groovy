package pages
import geb.Page

//Modified by Ricardo Barioni

class ColetaListPage extends Page{

    def titulo = "Coleta List"
    static url = "/ResS/coleta/list"


    static at = {
        title ==~ titulo
    }

    def gerarRel() {
    	$("a", href:"/ResS/coleta/genReport").click()
    }
    def selectTodayDate(){
        //$("select", name: "q_day").click()
        //$("select", name: "q_day").click()
        //$("select", name: "q2_day").click()
        //$("select", name: "q2_day").click()
        $("form").q_day = "1" 
        $("form").q_month = "12" 
        $("form").q_year = "2015"
        $("form").q2_day = "1" 
        $("form").q2_month = "12" 
        $("form").q2_year = "2015"  
    }

    def submit(){
        $("input", name: "ok").click()
    }
	def boolean hasErrors(){
		if($(".errors") == null){
			return false
		}else{
			return true
		}
	}

	def boolean hasOk(){
		if($(".ok") == null){
			return false
		}else{
			return true
		}
	}
	
}
