package steps

import pages.ColetaCreatePage
import pages.ColetaListPage
import HistoricoDeColeta.Coleta
import static cucumber.api.groovy.EN.*


//Updated by Ricardo Barioni on 19/10/2015


//CENARIO CONTROLADOR:
//Scenario: Blank Name input

Given (~'^I am logged in the system as a restaurant$'){ ->

    //login not implemented yet
}

When (~'^I register a residue collection request with Name "([^"]*)"$'){String name ->

    CreateColetaTestDataAndOperations.createColetaWithName(name)
}


Then (~'^The residue request with name "([^"]*)" is not generated$'){String name ->
    assert Coleta.findByNome(name) == null
}

//CENARIO CONTROLADOR:
//Scenario: Invalid volume input

Given (~'^I am logged on the system as a restaurant$'){ ->
    //login not implemented yet
}

When (~'^I register a residue collection request with Volume "([^"]*)"$'){String volume ->

    CreateColetaTestDataAndOperations.createColetaWithVolume(volume)
}

Then (~'^The residue request with volume "([^"]*)" is not created$'){String volume ->
    assert Coleta.findByVolume(volume) == null
}

//CENARIO GUI:
//Scenario: Blank Name input

Given (~'^I am at creating collection page$'){ ->
    to ColetaCreatePage
    at ColetaCreatePage
}

When (~'^I fill the request information with Name "([^"]*)"$'){String name ->
    page.fillName(name)
}

And (~'^I fill data and volume fields$'){ ->
    page.fillDataAndVolume()
}

And (~'^Choose "Create"$'){ ->
    page.submit()
}

Then (~'^I should see a error message$'){ ->

    to ColetaListPage
    at ColetaListPage
    assert page.hasErrors()
}

//CENARIO GUI:
//Scenario: Invalid volume input

Given (~'^I am on creating collection page$'){ ->

    to ColetaCreatePage
    at ColetaCreatePage
}

When (~'^I fill the request information with Volume "([^"]*)"$'){String volume ->
    page.fillVolume(volume)
}

And (~'^I fill name and data fields$'){ ->
    page.fillNameAndData()
}

And (~'^Select "Create"$'){ ->

    page.submit()
}

Then (~'^I see an error message$'){ ->

    to ColetaListPage
    at ColetaListPage
    assert page.hasErrors()
}

