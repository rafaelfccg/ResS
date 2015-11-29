package steps

import pages.ResidueGeneratorEditPage
import pages.ResidueGeneratorShowPage
import residueGenerator.ResidueGenerator
import static cucumber.api.groovy.EN.*

// ---------------------------------------------EDIT SUCCESS---------------------------------------------

Given(~'^the system has a residue generator with the address "([^"]*)"$') { String address ->
    GeneratorTestDataAndOperations.createGenerator(address)
    generator = ResidueGenerator.findByAddressGenerator(address)
    endereco = address
    assert generator != null
}

When (~'^I change it to "([^"]*)"$') {  String newAddress ->
    endereco = newAddress
    GeneratorTestDataAndOperations.editGenerator(endereco, generator)
}

Then(~'^the system should store the residue generator with the new address in the data base$') { ->
    assert ResidueGenerator.findByAddressGenerator(endereco) != null
}

Given(~'^the system has a residue genarator with CNPJ ([^"]*)$'){String cnpj->
    GeneratorTestDataAndOperations.createGeneratorCnpj(cnpj)
    generator = ResidueGenerator.findGeneratorByCnpj(cnpj)
    assert generator != null
}

When(~'^I change my cnpj to ([^"]*)$'){String newCnpj ->
    cnpj = newCnpj
    GeneratorTestDataAndOperations.editGeneratorCnpj(cnpj, generator)
}

Then(~'^generator with cnpj ([^"]*) is properly edited$'){->
    assert ResidueGenerator.findGeneratorByCnpj(cnpj) != null
}
/*
Given(~'^I am at the residue generator edit page'){ ->
    to ResidueGeneratorEditPage
    at ResidueGeneratorEditPage
}

And(~'^I updated my changes'){ ->
    page.submitChanges()
}

Then(~'^I can see a confirmation message'){->
    to ResidueGeneratorShowPage
    at ResidueGeneratorShowPage

    def hasMessage = page.hasMessage()

    assert hasMessage != null
}
*/

//----------------------------------------------------- FILL CNPJ INCORRECTLY-------------------------
/*
When(~'^I fill my cnpj to "([^"]*)"$'){ String cnpj ->
    newCnpj = cnpj
    GeneratorTestDataAndOperations.editGeneratorCnpj(newCnpj,generator)
}

Then(~'^the new cnpj is not edited'){
    assert ResidueGenerator.findGeneratorByCnpj(newCnpj) != null
}


/*
When(~'^I fill the cnpj field with "([^"]*)"$'){ String cnpj ->
    page.fillCnpjField(cnpj)

}


Then(~'^I can see a confirmation message'){
    at ResidueGeneratorEditPage
    def errorBoolean = page.hasInvalidMessage()
    assert errorBoolean != false
}
*/







Given(~'^I am at the residue generator edit page'){ ->
    to ResidueGeneratorEditPage
    at ResidueGeneratorEditPage
}

When(~'^I fill the address field with "([^"]*)"'){String address ->
    page.fillAddressField(address)
}

And(~'^fill all the required fields correctly'){ ->
    page.fillOtherFields()
}

And(~'^submit my changes'){ ->
    page.submitChanges()
}

Then(~'^I should see a message indicating that the changes are properly stored'){ ->
    to ResidueGeneratorShowPage
    at ResidueGeneratorShowPage

    def hasMessage = page.hasMessage()

    assert hasMessage != null
}

//---------------------------------------------LEAVING BLANK FIELDS------------------------------------------------------------


When(~'^I do not fill the address field$'){ ->
    nullAddress = null
}

And(~'^confirm my changes$'){ ->
    GeneratorTestDataAndOperations.editGenerator(nullAddress,generator)
}

Then(~'^the system should not store the changes'){ ->
    assert ResidueGenerator.findByAddressGenerator(endereco) != null
}

//------------------------------------------------DUPLICATED RESIDUE GENERATORS-------------------------------------------------


When(~'^I change it address to "([^"]*)"$'){ String newAddress  ->
    endereco = newAddress
    GeneratorTestDataAndOperations.editGenerator(endereco, generator)
}

//------------------------------------------------EDIT FAIL WEB PAGE------------------------------------------------------------

Then(~'^I should see a message indicating that an error occurred$'){ ->
    at ResidueGeneratorEditPage
    def errorBoolean = page.hasInvalidMessage()
    assert errorBoolean != false
}
