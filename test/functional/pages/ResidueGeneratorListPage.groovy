package pages
import geb.Page
import steps.GeneratorTestDataAndOperations

class ResidueGeneratorListPage extends Page{
    def titulo = "Residue Generator List"
    static url = "/ResS/residueGenerator/list"

    static at = {
        title ==~ titulo
    }


    def selectSortByAverageDailyMeal(){
        $("input", name: "sortByDailyMeals").click()
    }

    def checkOrderedBy(sortType){
        def firstResidueGeneratorColumns 	= this.getResidueGeneratorColumns(0)
        def secondResidueGeneratorColumns 	= this.getResidueGeneratorColumns(1)
                assert firstResidueGeneratorColumns[0].text().compareTo(secondResidueGeneratorColumns[0].text()) < 0
    }

    def getResidueGeneratorColumns(row){
        def listDiv = $('div', id: 'list-residueGenerator')
        def resGenTable = (listDiv.find('table'))[0]
        def resGenRows = resGenTable.find('tbody').find('tr')
        def resGenColumns = resGenRows[row].find('td')
        return resGenColumns
    }
}
