package pages
import geb.Page

class GeneratorCreatePage extends Page{

    def titulo = "Create Residue Generator"
    static url = "/ResS/residueGenerator/create"

    static at = {

         title ==~ titulo
    }

    def fillGeneratorDetails(LinkedHashMap gerador){

        $("form").nameGenerator = gerador.nameGenerator
        $("form").username = gerador.username
        $("form").password = gerador.password
        $("form").type = gerador.type
        $("form").cnpj = gerador.cnpj
        $("form").addressGenerator = gerador.addressGenerator
        $("form").averageMonthlyMeals = gerador.averageMonthlyMeals
        $("form").averageDailyMeals = gerador.averageDailyMeals

    }

    def fillGeneratorDetailsIncomplete(LinkedHashMap gerador){

        $("form").nameGenerator = gerador.nameGenerator
        $("form").type = gerador.type
        $("form").cnpj = ""
        $("form").averageMonthlyMeals = gerador.averageMonthlyMeals
        $("form").averageDailyMeals = gerador.averageDailyMeals

    }

    def selectCreateGenerator(){
        $("input", name: "create").click()
    }

    def boolean hasErrors(){
        if($(".errors") == null){
            return false
        }else{
            return true
        }
    }

}