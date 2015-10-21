package steps

import pages.GeneratorCreatePage
import pages.ResidueGeneratorShowPage
import residueGenerator.ResidueGenerator
import static cucumber.api.groovy.EN.*

/**
 * Created by Arthur on 01/05/2015.
 * Modified by Rafael Gouveia on 02/10/2015
 */

//Controlador
/*Scenario : new valid generator
Given: That there is no generator with address "Rua Japecanga, 182"
And  there is no registered username  "Los_Pollos" in the database
And the password  "Abcd1234@" follow the security rules
When: I register the residue generator account "Los Pollos" with password "Abcd1234@“ and address "Rua Japecanga, 182"
Then: The account "Los_Pollos" with password "Abcd1234@" is created

*/
//#if ($RegisterAResidueGenerator)
Given(~'^That there is no generator with address "([^"]*)"$') { String address ->
    generator = ResidueGenerator.findByAddressGenerator(address)
    assert generator == null
}
And(~'there is no registered username "([^"]*)" in the database"$'){String username->
    generator = GeneratorTestDataAndOperations.findGeneratorByUsername(username)
    assert generator == null

}
And(~'^the password "([^"]*)" follow the security rules$'){String password->
    assert  GeneratorTestDataAndOperations.verifySecurityOfPassword(password)

}
When(~'I register the residue generator account "([^"]*)" with password "([^"]*)“ and address "([^"]*)"$'){ String username, String password, String address ->
    endereco = address
    GeneratorTestDataAndOperations.createGeneratorUsernamePasswordAddress(username,password,address)
}


Then (~'^The account "([^"]*)" with password "([^"]*)" is created$'){ String username, String password->
    generator =  GeneratorTestDataAndOperations.findGeneratorByUsername(username)
    assert generator.password == password
    assert generator.addressGenerator == endereco
}

//Scenario : duplicated residue generator username
//Given: That there is no generator with address "Rua Japecanga, 182"
//And  there is a registered username  "Los_Pollos" in the database
//And the password  "Abcd1234@" follow the security rules
//When: I register the residue generator account "Los_Pollos" with password "Abcd1234@“ and address "Rua Japecanga, 182"
//Then: The account new "Los_Pollos" with password "Abcd1234@" is not created


And(~'there is a registered username "([^"]*)" in the database$'){String username->
    GeneratorTestDataAndOperations.createGeneratorUsername(username)
    generator = GeneratorTestDataAndOperations.findGeneratorByUsername(username)
    assert generator != null

}

Then (~'^The account new "([^"]*)" with password "([^"]*)" is not created$'){ String username, String password->
    generators = GeneratorTestDataAndOperations.findAllGeneratorByUsername(username)
    assert generators.size() == 1
}


//GUI
//Scenario: new valid generator web
//Given I am at the register new generator page
//When I fill the residue generator information with username "Los_Pollos"
//And username "Los_Pollos" has not been created yet
//And I register the new generator
//Then I see a confirmation message

Given(~'^I am at the register new generator page$'){ ->
    to GeneratorCreatePage
    at GeneratorCreatePage

}

When(~'^I fill the residue generators information with username "([^"]*)"$') { String username ->
    // Express the Regexp above with the code you wish you had
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.getGeneratorByUsername(username);
    page.fillGeneratorDetails(generator)
}

And(~'^username "([^"]*)" has not been created yet'){String username ->

    generator = GeneratorTestDataAndOperations.findGeneratorByUsername(username)
    if(generator != null){
        generator.delete(flush:true)
    }
    generator = GeneratorTestDataAndOperations.findGeneratorByUsername(username)
    assert  generator == null
}

And(~'^I register the new generator'){ ->
    page.selectCreateGenerator()
}

Then(~'^I see the show generator page'){ ->
    at ResidueGeneratorShowPage
    //assert withConfirm(true) { $("input", name: "showConfirm").click() } == "Generator was created!"
}

//Scenario: duplicated residue generator username web
//Given I am at the register new generator page
//When I fill the residue generators information with username "Los_Pollos"
//And username "Los_Pollos" has already been created
//And I register the new generator
//Then I see a error message

And(~'^username "([^"]*)" has already been created'){String username ->
    generator = GeneratorTestDataAndOperations.findGeneratorByUsername(username)
    assert  generator != null
}

Then(~'^I see a error message'){ ->
    assert page.hasErrors()
}
//#end

Given(~'^The system has no generator with the address "([^"]*)"$') { String address ->
    generator = ResidueGenerator.findByAddressGenerator(address)
    assert generator == null
}

When(~'I register a different generator of residue with the address "([^"]*)"$'){ String address ->
    GeneratorTestDataAndOperations.createAltGenerator(address)


}

When (~'^I register a new generator of residue with the address "([^"]*)"$'){String address ->
    endereco = address
    GeneratorTestDataAndOperations.createGenerator(address)
    generator = ResidueGenerator.findByAddressGenerator(address)
    assert generator != null
}

Given (~'^The system has a generator with the address "([^"]*)" already stored$$'){String address ->
    endereco = address
    GeneratorTestDataAndOperations.createGenerator(address)

}

Then (~'^The new residue generator is properly stored by the system$'){ ->
    assert ResidueGenerator.findByAddressGenerator(endereco) != null
}


When(~'^I fill the generator details with the address "([^"]*)"$'){String address ->
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.getGeneratorByAddress(address);
    page.fillGeneratorDetails(generator)
}

Then (~'^I should see a message indicating that the action was successful$'){ ->
    assert page.readFlashMessage() != null
}

Then (~'^The new residue generator is not stored twice by the system$') { ->
    generator = ResidueGenerator.findByAddressGenerator("Bubble Street number 7")
    assert generator.nameGenerator != "Alt"
}

When (~'^I register a different generator with the address "([^"]*)"$'){ String address ->
    to GeneratorCreatePage
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.getAltGenerator(address);
    page.fillGeneratorDetails(generator)
}

Then(~'^I should see an error message$'){ ->
    assert page.hasErrors()
}

When (~'I register a new generator of residue with some info left incomplete$'){ ->

}

And(~'The address "([^"]*)"$'){ String address ->
    endereco = address
    GeneratorTestDataAndOperations.createIncompleteGenerator(address)
}

Then(~'The new residue generator is not stored by the system$'){->
    assert ResidueGenerator.findByAddressGenerator(endereco) == null
}

When(~'I fill the generator details with some fields left incomplete$'){->
    to GeneratorCreatePage
    GeneratorTestDataAndOperations GTDO = new GeneratorTestDataAndOperations();
    LinkedHashMap generator = GTDO.getGenerator();
    page.fillGeneratorDetailsIncomplete(generator)

}
