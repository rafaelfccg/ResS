package steps

import pages.AdminUserShowPage
import user.AdminUser

import static cucumber.api.groovy.EN.*

/*
Given the system has an user with name "John Doe", CPF "123.456.789-12",
login "adminuser", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
When I ask the system to delete it
Then the user "admin" should not be stored anymore

Given the system has an user with name "John Doe", CPF "123.456.789-12",
login "adminuser", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
And I am at the user show page
When I ask the system to delete the user
Then I should see a confirmation message
 */

Given(~'^the system has an user with name "([^"]*)", CPF "([^"]*)", login "([^"]*)", password "([^"]*)", email "([^"]*)" and phone "([^"]*)"$') {
    String name, String cpf, String login, String password, String email, String phone ->
    user = AdminUser.findByAdminLogin(login)
    if(user == null){
        AdminUserTestDataAndOperations.createUser(name, cpf, login, password, email, phone)
    }
    user = AdminUser.findByAdminLogin(login)
    assert user != null
}
When(~'^I am at the user show page$') { ->
    to AdminUserShowPage
    at AdminUserShowPage
}
When(~'^I ask the system to delete the user$') { ->
    page.deleteUser()
}
When(~'^I ask the system to delete it$') { ->
    AdminUserTestDataAndOperations.deleteUser(user)
}
Then(~'^I should see a confirmation message$') { ->
    assert page.readFlashMessage() != null
}
Then(~'^the user "([^"]*)" should not be stored anymore$') { String login ->
    user = AdminUser.findByAdminLogin(login)
    assert user == null
}