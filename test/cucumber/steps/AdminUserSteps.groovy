package steps

import pages.AdminUserSignUpPage
import user.AdminUser
import static cucumber.api.groovy.EN.*

/*
Controller

Given the system has no user with the CPF "123.456.789-12"
And has no user with the login "admin"
When I register a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
Then the user "admin" is stored in the system

Given the system already has a user with the login "admin"
When I register a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
Then the user "admin" is not stored in the system
*/

Given(~'^the system has no user with the CPF "([^"]*)"$'){String cpf->
    userCpf = AdminUser.findByAdminCpf(cpf)
    assert userCpf == null
}

Given(~'^the system already has a user with the login "([^"]*)"$'){String login->
    AdminUserTestDataAndOperations.createUser(login)
    userLogin = AdminUser.findByAdminLogin(login)
    assert userLogin != null
}

And(~'^has no user with the login "([^"]*)"$'){String login->
    userLogin = AdminUser.findByAdminLogin(login)
    assert userLogin == null
}
When(~'^I register a user called "([^"]*)", with CPF "([^"]*)", login "([^"]*)", password "([^"]*)", email "([^"]*)" and phone "([^"]*)"$'){
    String name, String cpf, String login, String password, String email, String phone ->
        AdminUserTestDataAndOperations.createUser(name, cpf, login, password, email, phone)
}
Then(~'^the user "([^"]*)" is stored in the system$'){ String login ->
    userLogin = AdminUser.findByAdminLogin(login)
    assert userLogin != null
}
Then(~'^the user "([^"]*)" is not stored in the system$'){ String login ->
    userList = AdminUser.findAllByAdminLogin(login)
    assert userList.size() == 1
}


/*
GUI

Given I’m at the sign up page
And there is no user with the login "admin"
And there is no user with the CPF "123.456.789.12"
When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
Then I see a confirmation message

Given I’m at the sign up page
	And there’s already a user with the login "admin"
	When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then I see a message saying the registration failed
*/

Given(~'^I’m at the sign up page$'){->
    to AdminUserSignUpPage
    at AdminUserSignUpPage
}

And(~'^there’s already a user with the login "([^"]*)"$'){ String login->
    AdminUserTestDataAndOperations.createUser(login)
    user = AdminUser.findByAdminLogin(login)
    assert user != null
}
And(~'^there is no user with the login "([^"]*)"$'){ String login->
    user = AdminUser.findByAdminLogin(login)
    if(user != null){
        user.delete(flush:true)
    }
    user = AdminUser.findByAdminLogin(login)
    assert  user == null
}
And(~'^there is no user with the CPF "([^"]*)"$'){ String cpf->
    user = AdminUser.findByAdminCpf(cpf)
    if(user != null){
        user.delete(flush:true)
    }
    user = AdminUser.findByAdminCpf(cpf)
    assert  user == null
}

When(~'^I ask the system to add a user called "([^"]*)", with CPF "([^"]*)", login "([^"]*)", password "([^"]*)", email "([^"]*)" and phone "([^"]*)"$'){
    String name, String cpf, String login, String password, String email, String phone ->
        page.fillUserInfo(name, cpf, login, password, email, phone)
        page.submitUserInfo()
}
Then(~'^I see a message confirming the user registration$'){->
    assert page.readFlashMessage() != null
}
Then(~'^I see a message saying the registration failed$'){->
    assert page.readFlashMessage() != null
}