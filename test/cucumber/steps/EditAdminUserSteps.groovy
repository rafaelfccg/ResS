package steps

import pages.AdminUserEditPage
import user.AdminUser

import static cucumber.api.groovy.EN.*

/*
Controller

Given the system has an user with the email "johndoe@johndoe.com"
And I leave the new email blank
Then the new information is not stored in the system

GUI
Scenario: edit admin user gui
	Given the system has an user with the email "johndoe@johndoe.com"
	And I am at the edit user page
	When I ask the system to change the email to "email@email.com"
	Then a confirmation message is displayed

Scenario: edit admin user leaving blank field gui
	Given the system has an user with the email "johndoe@johndoe.com"
	And I am at the edit user page
	When I ask the system to change the email to blank
	Then an error message is displayed
*/

Given(~'^the system has an user with the email "([^"]*)"$'){ String oldEmail->
    AdminUserTestDataAndOperations.createUserByEmail(oldEmail)
    user = AdminUser.findByAdminEmail(oldEmail)
    assert user != null
}

And(~'^I am at the edit user page$'){ ->
    to AdminUserEditPage
    at AdminUserEditPage
}
When(~'^I change the email to "([^"]*)"$') { String email ->
    AdminUserTestDataAndOperations.editUser(email,user)
}
When(~'^I ask the system to change the email to blank$') { ->
    page.fillEmail("")
    page.submitUserInfo()
}
When(~'^I ask the system to change the email to "([^"]*)"$') { String email ->
    page.fillEmail(email)
    page.submitUserInfo()
}
When(~'^I leave the new email blank$'){ ->
    newEmail = null
    AdminUserTestDataAndOperations.editUser(newEmail,user)
}
Then(~'^a confirmation message is displayed$'){->
    assert page.readFlashMessage() != null
}
Then(~'^an error message is displayed$'){->
    assert page.readFlashMessage() != null
}
Then(~'^the new information is not stored in the system$'){ ->
    assert AdminUser.findByAdminEmail(newEmail) == null
}
Then(~'^the user with the email "([^"]*)" is stored$'){ String email ->
    assert AdminUser.findByAdminEmail(email) != null
}