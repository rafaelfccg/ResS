Feature: Register a residue Collector
  As an administrator of the ResS system
  I want to register a residue collector
  So that I can use and manage the information of these collectors

#@ignore

#Controller
  @ignore
  Scenario: Register new Collector
	Given that there is no collector with email "prefeitura_do_recife@recife.com.br"
	And there is no registered CNPJ "12300012300011" in the database
	When I register the new collector with email "prefeitura_do_recife@recife.com.br"
	And with CNPJ "12300012300011"
	Then the collector with email "prefeitura_do_recife@recife.com.br"
	And CNPJ "12300012300011" is created in the system
  @ignore
  Scenario: Register a duplicated collector
	Given that there is a registered collector with email "prefeitura_do_recife@recife.com.br"
	And CNPJ "12300012300011" in the system
	When I try to register a new collector with email "prefeitura_do_recife@recife.com.br" or CNPJ "12300012300011"
	Then the new collecor with email "prefeitura_do_recife@recife.com.br"
	And CNPJ "12300012300011" is not created


  Scenario: Edit existing collector
	Given that there is a collector with email "prefeitura_do_recife@recife.com.br"
	And I am at the editing page of this collector
	When I change the field name to "Prefeitura"
	And I click on "Save" button
	Then the collector's name is changed successfully

  Scenario: Delete existing collector
	Given that there is a collector with email "prefeitura_do_recife@recife.com.br"
	And I am at the editing page of this collector
	When I click on the "delete" button
	And confirm the deletion
	Then the collector is deleted from the database
	And there it does not exist on the database anymore

#GUI
  @ignore
  Scenario: Register new Collector
	Given that I am at the form page of register new collector
	And I fill the fields with new Collector information
	And there is no Previous collector with the email
	And CNPJ I filled in the form
	When I press the button "Register new Collector"
	Then the system show me a success message "The collecter has been registered with success!"

  @ignore
  Scenario: Register duplicated Collector
	Given that I am at the form page of register new collector
	And I fill the field with new Collector information
	And there is a previous Collector with the email
	And CNPJ I filled in the form
	When I press the button "Register new Collector"
	Then the system show me a error message "It is not possible to add this new Collector. This email or CNPJ is already being used!"

  Scenario: Edit an existing collector
	Given that there is a collector with email "prefeitura_do_recife@recife.com.br"
	And I am at the editing page of this collector
	When I change the field name to "Prefeitura"
	And I click on "Save" button
	Then I see a message "The collector's change was saved successfully!"

  Scenario: Delete existing collector
	Given that there is a collector with email "prefeitura_do_recife@recife.com.br"
	And I am at the editing page of this collector
	When I click on the "delete" button
	Then A confirmation dialog shows up asking "Are you sure you want to delete this collector?"