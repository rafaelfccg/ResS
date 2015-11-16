Feature: admin user
  As a researcher
  I want to be able to see reports and notifications from restaurants and collectors
  So that I can have a bigger control of all the information

#if($adminUserRegistration)
  Scenario: Add a new user
	Given the system has no user with the CPF "123.456.789-12"
	And has no user with the login "admin"
	When I register a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then the user "admin" is stored in the system
@ignore
  Scenario: Add a new user with existing login
	Given the system already has a user with the login "admin"
	When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then the user "admin" is not stored in the system
@ignore
  Scenario: Add a new user (gui)
	Given I’m at the sign up page
	When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then I see a message confirming the user registration
@ignore
  Scenario: Add a new user with existing login (gui)
	Given I’m at the sign up page
	And there’s already a user with the login "admin"
	When I ask the system to add a user called "John Doe", with CPF "123.456.789-12", login "admin", password "abcdef", email "johndoe@johndoe.com" and phone "0000-0000"
	Then I see an error message
#end