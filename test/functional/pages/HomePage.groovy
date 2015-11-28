package pages
import geb.Page
class HomePage extends Page {


    def titulo = "ResS"
    static url = "/ResS/dashboard"

    static at = {
        title ==~ titulo
    }

    def selectResidueGeneratorArea(){
        $('#ResidueGenerator').click();
    }

    def selectGithubRibbon(){
        $('#forkongithublink').click();
    }
}
