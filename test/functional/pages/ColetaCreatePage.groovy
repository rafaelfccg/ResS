package pages

import geb.Page

//Created by Ricardo Barioni

class ColetaCreatePage extends Page {

    def titulo = "Create Coleta"
    static url = "/ResS/coleta/create"
    
    static at = {
        title ==~ titulo
    }
    
    def fillName (String name) {
        $("form").nome = name
    }
    
    def fillDataAndVolumeAndPassword () {
        $("form").data_day = "6"
        $("form").data_month = "8"
        $("form").data_year = "2010"
        $("form").volume = 800
        $("form").senha = "123456"
    }
    
    def fillVolume (String volume) {
        $("form").volume = volume
    }
    
    def fillNameAndDataAndPassword () {
        $("form").nome = "RU"
        $("form").data_day = "6"
        $("form").data_month = "8"
        $("form").data_year = "2010"
        $("form").senha = "123456"
    }

    def fillVolumeAndPassword (String volume, String password) {
        $("form").volume = 800
        $("form").senha = "123456"
    }

    def fillNameAndData () {
        $("form").nome = "RU"
        $("form").data_day = "6"
        $("form").data_month = "8"
        $("form").data_year = "2010"
    }
    
    def submit () {
        $("input", name: "create").click()
    }

}
