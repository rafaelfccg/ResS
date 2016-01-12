package steps

import pages.ColetaCreatePage
import pages.ColetaListPage
import HistoricoDeColeta.Coleta
import static cucumber.api.groovy.EN.*


//Updated by Ricardo Barioni on 19/10/2015

//CONTROLLER
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

//-----

//CENARIO CONTROLADOR:
//Scenario: Positive volume and valid password input

Given (~'^I am logged in the system as restaurant$'){ ->
    //login not implemented yet
}

When (~'^I register a residue collection request with Volume "([^"]*)" and password "([^"]*)"$'){String volume, String password ->
    CreateColetaTestDataAndOperations.createColetaWithVolumeAndPassword(volume, password)
}

Then (~'^The residue request with Volume "([^"]*)" and password "([^"]*)" is generated$'){String volume, String password ->
    assert CreateColetaTestDataAndOperations.findColetaByVolumeAndPassword(volume, password) != null
}

//CENARIO CONTROLADOR:
//Scenario: Negative volume and valid password input

Given (~'^I am logged on the system as restaurant$'){ ->
    //login not implemented yet
}

When (~'^I register a new residue collection request with Volume "([^"]*)" and password "([^"]*)"$'){String volume, String password ->
    CreateColetaTestDataAndOperations.createColetaWithVolumeAndPassword(volume, password)
}

Then (~'^The residue request with Volume "([^"]*)" and password "([^"]*)" is not generated$'){String volume, String password ->
    assert Coleta.findByVolumeAndSenha(volume, password) == null
}

//GUI
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
    page.fillDataAndVolumeAndPassword()
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
    page.fillNameAndDataAndPassword()
}

And (~'^Select "Create"$'){ ->
    page.submit()
}

Then (~'^I see an error message$'){ ->
    to ColetaListPage
    at ColetaListPage
    assert page.hasErrors()
}

//-----

//CENARIO GUI:
//Scenario: Positive volume and valid password input

Given (~'^I am at the creating collection page$'){ ->
    to ColetaCreatePage
    at ColetaCreatePage
}

When (~'^I fill the request information with Volume "([^"]*)" and password "([^"]*)"$'){String volume, String password ->
    page.fillVolumeAndPassword(volume, password)
}

And (~'^Fill name and data fields$'){ ->
    page.fillNameAndData()
}

And (~'^I Select "Create"$'){ ->
    page.submit()
}

Then (~'^I should not see a error message$'){ ->
    to ColetaListPage
    at ColetaListPage
    assert page.hasOk()
}

//CENARIO GUI:
//Scenario: Negative volume and valid password input

Given (~'^I am on the creating collection page$'){ ->
    to ColetaCreatePage
    at ColetaCreatePage
}

When (~'^I fill the new request information with Volume "([^"]*)" and password "([^"]*)"$'){String volume, String password ->
    page.fillVolumeAndPassword(volume, password)
}

And (~'^Fill the name and data fields$'){ ->
    page.fillNameAndData()
}

And (~'^I Choose "Create"$'){ ->
    page.submit()
}

Then (~'^I shall see a error message$'){ ->
    to ColetaListPage
    at ColetaListPage
    assert page.hasErrors()
}
