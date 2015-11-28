package pages

import geb.Page

/**
 * Created by danie_000 on 5/2/2015.
 */
class ResidueGeneratorShowPage extends Page{

    def titulo = "http://localhost:8070/residueGenerator/show/1"
    static url = "residueGenerator/show/1"

    static at = {
        title ==~ titulo
    }

    def boolean hasMessage(){
        def message = $('.message')

        if(!message){
            return false
        } else {
            return true
        }
    }


    //LIST FEATURE
    def selectListResidueGenerators(){
        $("input",name: "listResidueGenerators").click()
    }
    //
}
