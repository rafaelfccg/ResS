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