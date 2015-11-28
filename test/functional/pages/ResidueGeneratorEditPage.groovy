package pages

import geb.Page
import steps.GeneratorTestDataAndOperations

class ResidueGeneratorEditPage extends Page{

    def titulo = "Editar ResidueGenerator"
    static url = "/ResS/residueGenerator/edit/1"

    static at = {
        title ==~ titulo
    }

    def fillAddressField(String address){
        $("form").addressGenerator = address
    }

    def fillOtherFields() {
        GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
        LinkedHashMap gerador = GTDO.getGenerator();
        $("form").nameGenerator = gerador.nameGenerator
        $("form").type = gerador.type
        $("form").cnpj = gerador.cnpj
        $("form").averageMonthlyMeals = gerador.averageMonthlyMeals
        $("form").averageDailyMeals = gerador.averageDailyMeals
    }

    def fillCnpjField(String cnpj){
        $("form").cnpj = cnpj
    }


    def fillOtherFieldsCnpj() {
        GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
        LinkedHashMap gerador = GTDO.getGenerator();
        $("form").addressGenerator = gerador.addressGenerator
        $("form").nameGenerator = gerador.nameGenerator
        $("form").type = gerador.type
        $("form").averageMonthlyMeals = gerador.averageMonthlyMeals
        $("form").averageDailyMeals = gerador.averageDailyMeals
    }


    def submitChanges(){
        $("input", name: "edit").click()
    }

    def boolean hasInvalidMessage(){

        def invalidField = $('input:invalid')

        if(invalidField != null){
            return true
        } else {
            return false
        }
    }
}