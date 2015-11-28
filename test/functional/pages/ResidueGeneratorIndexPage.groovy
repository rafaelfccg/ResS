package pages
import geb.Page

class ResidueGeneratorIndexPage extends Page {

    def titulo = "Residue Generator List"
    static url = "/ResS/residueGenerator/list"

    static at = {
        title ==~ titulo
    }

}
