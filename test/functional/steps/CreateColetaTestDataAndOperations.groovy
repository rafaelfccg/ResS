package steps

import HistoricoDeColeta.Coleta
import HistoricoDeColeta.ColetaController
import steps.NoColetasException

//Created by Ricardo Barioni

class CreateColetaTestDataAndOperations {

    def exportService
    def grailsApplication

    static coletaName = [

            [
                    nome : "",
                    data : ("03/10/2015"),
                    volume: 30,
                    senha: "123456"
            ]
    ]

    static coletaVolume = [
            [
                    nome : "Cuscuz",
                    data : ("03/10/2015"),
                    volume: 0,
                    senha: "123456"
            ]

    ]

    static coletaVolumePassword = [
            [
                    nome : "Lanche feliz",
                    data : ("03/10/2015"),
                    volume: 20,
                    senha: "123456"
            ],

            [
                    nome : "Lanche feliz",
                    data : ("03/10/2015"),
                    volume: -20,
                    senha: "123456"
            ]

    ]

    static coletaDate = [
            [
                    nome: "Cuscuz",
                    data: ("03/11/2015"),
                    volume: 20
            ]

    ]

    static coletaReport = [
            [
                    nome: "Cuscuz",
                    data: ("03/10/2015"),
                    volume: 0
            ],
            [
                    nome: "Cuscuz",
                    data: ("03/10/2015"),
                    volume: 0
            ],
            [
                    nome: "Cuscuz",
                    data: ("03/10/2015"),
                    volume: 0
            ],
            [
                    nome: "Cuscuz",
                    data: ("03/11/2015"),
                    volume: 30
            ],
            [
                    nome: "Cuscuz",
                    data: ("03/11/2015"),
                    volume: 40
            ],


    ]

    static public def findColetaByName(String name) {
        coletaName.find { coleta ->
            coleta.nome == name
        }
    }

    static public def findColetaByVolume(String volume) {
        int volumeNumber = volume.toInteger();
        coletaVolume.find { coleta ->
            coleta.data == volumeNumber

        }
    }


    static public def findColetaByVolumeAndPassword(String volume, String password) {
        int volumeNumber = volume.toInteger();
        coletaVolumePassword.find { coleta ->
            coleta.volume == volumeNumber
            coleta.senha == password

        }

    }

    static public def findColetaByDate(String date) {
        //int dateForReal = date.toInteger();
        coletaReport.find { coleta ->

            coleta.data.contains(date)

        }

    }

    static public void createColetaWithDate(String date) {
        def cont = new ColetaController()
        def novaColeta = findColetaByDate(date)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void createColetaWithName(String name) {
        def cont = new ColetaController()
        def novaColeta = findColetaByName(name)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }


    static public void createColetaWithVolume(String volume) {
        def cont = new ColetaController()
        def novaColeta = findColetaByVolume(volume)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void createColetaWithVolumeAndPassword(String volume, String password) {
        def cont = new ColetaController()
        def novaColeta = findColetaByVolumeAndPassword(volume, password)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public String calcVolume(String date) {
        def coletas = findColetaByDate(date)
        if (coletas) {
            int count = coletas.grep { it.key =~ 'volume' }.value.sum()
            return count + ""
        } else {
            throw new NoColetasException("Sem coletas compativeis", coletas)
        }
    }

    static public boolean genCSV(String date) {
        def coletas = findColetaByDate(date)
        //def response;
        if (coletas) {
           // response.contentType = grailsApplication.config.grails.mime.types[params.format]
           // response.setHeader("Content-disposition", "attachment; filename=Relatorio.${params.extension}")
                    
           // def c = exportService.export(params.format, response.outputStream,coletas, [:], [:])
            
            return true
        } else {
            throw new NoColetasException("Sem coletas compativeis", coletas)
        }
    }

}

