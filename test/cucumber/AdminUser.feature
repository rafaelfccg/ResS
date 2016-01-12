Feature: admin user
  As a researcher
  I want to be able to see reports and notifications from restaurants and collectors
  So that I can have a bigger control of all the information


#if ($editAdminUser)
  Scenario: edit admin user leaving blank field
	Given the system has an user with the email "johndoe@johndoe.com"
	And I leave the new email blank
	Then the new information is not stored in the system
@ignore
  Scenario: edit admin user
	Given the system has an user with the email "johndoe@johndoe.com"
	When I change the email to "email@email.com"
	Then the user with the email "email@email.com" is stored

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
#end

 #if ($deleteAdminUser)
  Scenario: delete admin user
	Given the system has an user with name "John Doe", CPF "123.456.789-12", login "adminuser", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	When I ask the system to delete it
	Then the user "adminuser" should not be stored anymore
  Scenario: delete admin user gui
	Given the system has an user with name "John Doe", CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	And I am at the user show page
	When I ask the system to delete the user
	Then I should see a confirmation message
#end

#if($adminUserRegistration)
  Scenario: Add a new user
	Given the system has no user with the CPF "123.456.789-12"
	And has no user with the login "adminlogin"
	When I register a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then the user "admin" is stored in the system
   Scenario: Add a new user with existing login
	Given the system already has a user with the login "admin"
	When I register a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then the user "admin" is not stored in the system
  Scenario: Add a new user (gui)
	Given I’m at the sign up page
	And there is no user with the login "admin"
	And there is no user with the CPF "123.456.789.12"
	When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then I see a message confirming the user registration
  Scenario: Add a new user with existing login (gui)
	Given I’m at the sign up page
	And there’s already an user with the login "admin"
	When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then I see a message saying the registration failed
#end
