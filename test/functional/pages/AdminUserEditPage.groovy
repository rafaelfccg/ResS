package pages
import geb.Page

class AdminUserEditPage extends Page {
    def titulo = "Edit Admin User"
    static url = "/ResS/adminUser/edit/1"

    static at = {
        title ==~ titulo
    }

    def fillEmail(String email){
        $("form").adminEmail = email
    }

    def submitUserInfo(){
        $("input", name: "edit").click()
    }
}
