package pages

import geb.Page

class LoginPage extends Page{

    def titulo = "ResS - login"
    static url = "ResS/home/login"

    static at = {
        title ==~ titulo
    }


    def fillCred(String cnpj){
        $("form").cnpj = cnpj

    }


    def fillPass(String pass){
        $("form").password = pass

    }

    def submit(){
        $("input", name: "_action_logar").click()
    }

}
