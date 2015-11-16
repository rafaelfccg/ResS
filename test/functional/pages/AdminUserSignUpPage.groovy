package pages
import geb.Page

class AdminUserSignUpPage extends Page {
    def titulo = "Sign Up"
    static url = "/ResS/adminUser/create"

    static at = {
        title ==~ titulo
    }

    def fillUserInfo(String name, String cpf, String login, String password, String email, String phone){
        $("form").adminName = name
        $("form").adminCpf = cpf
        $("form").adminLogin = login
        $("form").adminPassword = password
        $("form").adminEmail = email
        $("form").adminPhone = phone
    }

    def submitUserInfo(){
        $("input", name: "submit").click()
    }

    def boolean hasErrors(){
        if($(".errors") == null){
            return false
        }else{
            return true
        }
    }
}
