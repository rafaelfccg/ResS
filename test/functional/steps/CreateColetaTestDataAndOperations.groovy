package steps

import HistoricoDeColeta.Coleta
import HistoricoDeColeta.ColetaController

//Created by Ricardo Barioni

class CreateColetaTestDataAndOperations {

    static coletaName = [

            [
                    nome: "",
                    data: ("03/10/2015"),
                    volume: 30,
                    senha: "123456"
            ]
    ]

    static coletaVolume = [
            [
                    nome: "Cuscuz",
                    data: ("03/10/2015"),
                    volume: 0,
                    senha: "123456"
            ]

    ]

    static coletaVolumePassword = [
            [
                    nome: "Lanche feliz",
                    data: ("03/10/2015"),
                    volume: 20,
                    senha: "123456"
            ],

            [
                    nome: "Lanche feliz",
                    data: ("03/10/2015"),
                    volume: -20,
                    senha: "123456"
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

    static public def findColetaByVolumeAndPassword (String volume, String password) {
        int volumeNumber = volume.toInteger();
        coletaVolumePassword.find { coleta ->
            coleta.volume == volumeNumber
            coleta.senha == password
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

    static public void createColetaWithVolumeAndPassword (String volume, String password) {
        def cont = new ColetaController()
        def novaColeta = findColetaByVolumeAndPassword(volume, password)
        cont.params << novaColeta
        cont.create()
        cont.save()
        cont.response.reset()
    }

}

