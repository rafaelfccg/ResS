package steps

import HistoricoDeColeta.*
import cucumber.api.Format

class HistoricoTestDataAndOperations {

    static  coletas = [

             nome:"RU",
             data: ("08/04/2015"),
             volume: 101,
             senha: "123456"

    ]

    static public def getColeta(){
        return findColetaByNomeData("RU","08/04/2015" )
    }

    static public def findColetaByNomeData(String rest,@Format("dd/MM/yyyy") Date date ) {
        coletas.find { coleta ->
            coleta.nome == rest
            coleta.data == date
        }
    }



    static public void CreateHistorico(String rest,@Format("dd/MM/yyyy") Date dia){
        def cont = new ColetaController()

        cont.params << [nome: rest, data: dia, volume: 101, senha: "123456"]
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void editColeta(int volume,Coleta coleta){
        def colet = coleta
        colet.setVolume(volume)
        def cont =  new ColetaController()
        cont.params << colet.properties
        cont.update()
    }

    static public void editNomeColeta(String novoNome,Coleta coleta){
        def colet = coleta
        colet.setName(novoNome)
        def cont =  new ColetaController()
        cont.params << colet.properties
        cont.update()


    }

    static public void editDataColeta(@Format("dd/MM/yyyy") Date novaData,Coleta coleta){
        def colet = coleta
        colet.setDate(novaData)
        def cont =  new ColetaController()
        cont.params << colet.properties
        cont.update()


    }

    static public void deleteColeta(Coleta coleta){
        def cont = new ColetaController()
        cont.params << [id: coleta.id]
        cont.request.setContent(new byte[1000])
        cont.delete()
        cont.response.reset()
    }


}
