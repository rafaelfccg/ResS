Feature: Register a residue Collector
	As an administrator of the ResS system
	I want to register a residue collector
	So that I can use and manage the information of these collectors

#@ignore

#Controller

	Scenario: Register new Collector
		Given that there is no collector with email "prefeitura_do_recife@recife.com.br"
		And there is no registered CNPJ "123000123/0001-1" in the database
		When I register the new collector with email "prefeitura_do_recife@recife.com.br"
		And with CNPJ "123000123/0001-1"
		Then the collector with email "prefeitura_do_recife@recife.com.br" 
		And CNPJ "123000123/0001-1" is created in the system

	Scenario: Register a duplicated collector
		Given that there is a registered collector with email "prefeitura_do_recife@recife.com.br" 
		And CNPJ "123000123/0001-1" in the system
		When I try to register a new collector with email "prefeitura_do_recife@recife.com.br" or CNPJ "123000123/0001-1"
		Then the new collecor with email "prefeitura_do_recife@recife.com.br" 
		And CNPJ "123000123/0001-1" is not created

#GUI

	Scenario: Register new Collector
		Given that I am at the form page of register new collector
		And I fill the fields with new Collector information
		And there is no Previous collector with the email
		And CNPJ I filled in the form
		When I press the button "Register new Collector"
		Then the system show me a success message "The collecter has been registered with success!"


	Scenario: Register duplicated Collector
		Given that I am at the form page of register new collector
		And I fill the field with new Collector information
		And there is a previous Collector with the email
		And CNPJ I filled in the form
		When I press the button "Register new Collector"
		Then the system show me a error message "It is not possible to add this new Collector. This email or CNPJ is already being used!"	

