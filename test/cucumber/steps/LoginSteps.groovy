package steps


import pages.LoginPage
import pages.HomePage
import residueGenerator.ResidueGenerator
import steps.GeneratorTestDataAndOperations
import steps.LoginTestDataAndOperations

import static cucumber.api.groovy.EN.*

// CONTROLLER STEPS

Given (~'^that there is an account registered by "([^"]*)" in the system$'){
    String name ->
        account = LoginTestDataAndOperations.findGeneratorByName(name)
        assert account != null
}

When (~'^I submit the "([^"]*)" CNPJ$'){
    String cnpj ->
        account = LoginTestDataAndOperations.findGeneratorByCNPJ(cnpj)
        assert account != null
}

And (~'^I submit the "([^"]*)" password$'){
    String pass ->
        assert LoginTestDataAndOperations.logar(pass) == true
}


Then (~'^I get access to repository of information in the system'){
    ->
}

//GUI

Given (~'^that I have an account registered in the system$'){
    -> to LoginPage
}

When (~'^I enter "([^"]*)" in the CNPJ field$'){
    String cnpj -> at LoginPage
        page.fillCred(cnpj)

}

And (~'^I enter "([^"]*)" password in the password field$'){
    String pass ->at LoginPage
        page.fillPass(pass)


}

And (~'^I submit the form via the Login button$'){
    ->at LoginPage
    page.submit()


}

Then (~'^I get redirected to my dashboard page'){
    ->at LoginPage
    to HomePage
}

And (~'^I get flashed a notice saying that I\'ve logged in'){
    -> at HomePage

}
