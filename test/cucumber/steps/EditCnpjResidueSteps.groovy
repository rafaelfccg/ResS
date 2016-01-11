import pages.ResidueGeneratorShowPage
import residueGenerator.ResidueGenerator
import steps.GeneratorTestDataAndOperations
import pages.ResidueGeneratorEditPage

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When
import static cucumber.api.groovy.EN.When



Given(~'^the system has a residue generator with cnpj "([^"]*)"$'){String bcnpj ->

    GeneratorTestDataAndOperations.createGeneratorCnpj(bcnpj)
    generator = GeneratorTestDataAndOperations.findGeneratorByCnpj(bcnpj)
    assert generator != null
}

When(~'^I change my cnpj to "([^"]*)"$'){String newCnpj ->
    acnpj = newCnpj
    GeneratorTestDataAndOperations.editGeneratorByCnpj(acnpj, generator)
}

Then(~'^the generator with cnpj "([^"]*)" is properly edited$'){ String cnpj ->

    assert GeneratorTestDataAndOperations.findGeneratorByCnpj(cnpj) != null
}


Then(~'^the generator with cnpj "([^"]*)" is not edited$') { String cnpj ->
    assert GeneratorTestDataAndOperations.findGeneratorByCnpj(cnpj) == null
}

When(~'^I fill the cnpj field with "([^"]*)"$'){String cnpj ->
    page.fillCnpjField(cnpj)
}


And(~'^I update my changes$'){ ->
    page.submitChanges()
}

Then(~'^I can see that the storing was confirmed$'){->
    to ResidueGeneratorEditPage
    at ResidueGeneratorEditPage
    def hasMessage = page.hasMessage()
    assert hasMessage != null
}

Then(~'^I can see a error message$'){->
    to ResidueGeneratorEditPage
    at ResidueGeneratorEditPage
    def hasInvalidMessage = page.hasInvalidMessage()
    assert hasInvalidMessage != null
}