package steps

import HistoricoDeColeta.Coleta
import HistoricoDeColeta.ColetaController

//Created by Ricardo Barioni

class CreateColetaTestDataAndOperations {

    static coletaName = [

            [
                    nome: "",
                    data: ("03/10/2015"),
                    volume: 30
            ]
    ]

    static coletaVolume = [
            [
                    nome: "Cuscuz",
                    data: ("03/10/2015"),
                    volume: 0
            ]

    ]

    static public def findColetaByName (String name) {
        coletaName.find { coleta ->

            coleta.nome == name
        }
    }

    static public def findColetaByVolume (String volume) {
        int volumeNumber = volume.toInteger();
        coletaVolume.find { coleta ->
            coleta.volume == volumeNumber

        }
    }

    static public void createColetaWithName (String name) {
        def cont = new ColetaController()
        def novaColeta = findColetaByName(name)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }


    static public void createColetaWithVolume (String volume) {
        def cont = new ColetaController()
        def novaColeta = findColetaByVolume(volume)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }

}

