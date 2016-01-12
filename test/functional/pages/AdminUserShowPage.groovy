package pages
import geb.Page

class AdminUserShowPage extends Page {
    def titulo = "Show AdminUser"
    static url = "/ResS/adminUser/show/1"

    static at = {
        title ==~ titulo
    }

    def deleteUser(){
        $("form", name: "delete").click()
    }
}
