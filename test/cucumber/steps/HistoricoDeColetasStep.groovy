package steps

import cucumber.api.Format
import pages.ColetaDeletePage
import pages.ColetaEditPage
import pages.ColetaListPage
import pages.HistoricoPage
import static cucumber.api.groovy.EN.*
import HistoricoDeColeta.Coleta

Given (~'^estou na pagina de adicionar coleta$'){ ->
    to HistoricoPage
    at HistoricoPage
}
When (~'^preencho os campos necessarios com informaçoes validas$'){ ->
    page.fillColetaInfo()
}
And (~'^clico em adicionar coleta do dia$'){ ->
    page.selectAdicionarColeta()
}
Then (~'^eh adicionada com sucesso$'){ ->
}


Given(~'^nao foi criada um relatorio de coleta do dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String restaurante ->
    coleta = Coleta.findByDataAndNome(dia,restaurante)
    assert coleta == null
}
When (~'^crio um novo relatorio o dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String rest ->
    data = dia
    restaurante = rest
    HistoricoTestDataAndOperations.CreateHistorico(rest,dia)
}
Then (~'o relatorio eh adicionado ao historico de coletas$'){ ->
    assert Coleta.findByDataAndNome(data,restaurante) != null
}


Given (~'^ja foi criado o relatorio de coleta do dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String restaurante ->
   dat = dia
    rest = restaurante
    c = Coleta.findByDataAndNome(dia,restaurante)
    assert c != null
}
When (~'altero o valor do volume da coleta para "([^\"]*)"$') { int vol ->
    volume = vol
    HistoricoTestDataAndOperations.editColeta(volume, c)

}
Then (~'o valor do volume eh atualizado$') { ->
    c = Coleta.findByDataAndNome(dat,rest)
    assert c.getVolume() == volume
}


Given  (~'^existe uma coleta do dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String restaurante ->
    coleta = Coleta.findByDataAndNome(dia,restaurante)
    assert coleta != null
}
When  (~'^seleciono remover esta coleta$'){ ->
    HistoricoTestDataAndOperations.deleteColeta(coleta)
}
Then  (~'^nao existem mais coleta dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String restaurante ->
    coleta = Coleta.findByDataAndNome(dia,restaurante)
    assert coleta == null
}


Given(~'^estou na pagina de editar coleta$'){ ->
    to HistoricoPage
    page.selectAdicionarColeta()
    to ColetaEditPage
    at ColetaEditPage
}
When(~'^coloco o novo volume "([^"]*)" a ser adicionado$'){int vol ->
    page.fillVolume(vol)
}
And(~'^coloco os outros dados corretamente$'){ ->
    page.fillOtherFields()
}
And(~'^e envio as mudancas'){ ->
    page.submitChanges()
}
Then (~'^o volume eh alterado com sucesso$'){ ->
}


Given(~'^ja existe uma coleta com nome "([^"]*)" e data "([^"]*)"$'){String nome, @Format("dd/MM/yyyy") Date dia ->
    HistoricoTestDataAndOperations.CreateHistorico(nome,dia)
    coletaAntiga = Coleta.findByNome(nome)
}
When(~'^tento criar uma nova coleta com nome "([^"]*)" e data "([^"]*)"$') {String novoNome, @Format("dd/MM/yyyy") Date novoDia ->
    HistoricoTestDataAndOperations.CreateHistorico(novoNome,novoDia)
    coletaNova = Coleta.findByNome(novoNome)
}
Then(~'^nao eh criada a nova coleta$') { ->
    c =  Coleta.findAllByNome(coletaAntiga.nome)
    assert c[0] == coletaAntiga
    assert c[1] != coletaNova
}



And(~'^existe outra coleta com nome "([^"]*)" e data "([^"]*)"$'){String nome, @Format("dd/MM/yyyy") Date dia ->
    HistoricoTestDataAndOperations.CreateHistorico(nome,dia)
    coletaEditada = Coleta.findByNomeAndData(nome,dia)
    nomeAntigo = nome
    dataAntiga = dia
}
When(~'^tento editar o nome "cantina" para "([^"]*)"$') {String novoNome->

    HistoricoTestDataAndOperations.editNomeColeta(novoNome,coletaEditada)
}
Then(~'^a edicao nao sera realizada$') { ->
    assert coletaEditada.nome == nomeAntigo
    assert coletaEditada.data == dataAntiga
}

When(~'^tento editar a data "07/11/2015" para "([^"]*)"$') { @Format("dd/MM/yyyy") Date novoDia->

    HistoricoTestDataAndOperations.editDataColeta(novoDia,coletaEditada)
}

Given(~'^estou na pagina de listagem de coletas$'){->
    to ColetaListPage
    at ColetaListPage
}
And(~'existe uma coleta na listagem$'){->
    to HistoricoPage
    page.fillColetaInfo()
    page.selectAdicionarColeta();
    to ColetaListPage
    at ColetaListPage
}
And(~'^seleciono esta coleta$') { ->
    to ColetaDeletePage
}
When(~'^aperto o botao Delete$') { ->
    assert withConfirm(true) {
        $("input", name: "_action_delete").click()} != "Are you sure?"

}
Then(~'^estou na pagina de listagem e esta coleta nao consta mais$') { ->
    at ColetaListPage
}