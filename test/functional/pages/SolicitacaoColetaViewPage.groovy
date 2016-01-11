package pages

import geb.Page

class SolicitacaoColetaViewPage extends Page {
    def titulo = "Solicitacao de coleta"

    static url = "ResS/generatorHarvestSolicitation/index/1"


    static at = {
        title ==~ titulo
    }

    def boolean hasLabel() {
        def confirmationClass = $('.labelContent')

        if (confirmationClass != null) {
            return true
        } else {
            return false
        }
    }

    def resendEmail() {

        $("input", name: "resendButton").click()
    }

    def boolean hasOk(){
        if($(".ok") == null){
            return false
        }else{
            return true
        }
    }
	
    def generateReport(){
	}
	
	def printReport(){
	}
}
