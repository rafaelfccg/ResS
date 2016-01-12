package pages
import geb.Page

class AdminUserListPage extends Page {
    def titulo = "Edit Admin User"
    static url = "/ResS/adminUser/list"


    static at = {
        title ==~ titulo
    }

}
