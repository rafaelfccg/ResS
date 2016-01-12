Feature: register a residue generator
  As an administrator of the ResS system
  I want to register residue generators
  So that I can use and manage information of these generators


#Controller

  Scenario: new valid generator
    Given That there is no restaurant with address "Rua Japecanga, 182"
    And there is no registered username "Los Pollos" in the database
    And the password "Abcd1234@" follow the security rules
    When I register the residue generator account "Los Pollos" with password "Abcd1234@“ and address "Rua Japecanga, 182"
    Then The account "Los Pollos" with password "Abcd1234@" is created

@ignore
  Scenario: duplicated residue generator username
    Given That there is no restaurant with address "Rua Japecanga, 182"
    And there is a registered username "Los Pollos" in the database
    And the password "Abcd1234@" follow the security rules
    When I register the residue generator account "Los Pollos" with password "Abcd1234@“ and address "Rua Japecanga, 182"
    Then The account "Los Pollos" with password "Abcd1234@" is not created

#GUI

  Scenario: new valid generator web
    Given I am at the register new generator page
    When I fill the residue generator information with username "Los_Pollos2"
    And username "Los_Pollos2" has not been created yet
    And I register the new generator
    Then A generator is stored at the system


  Scenario: duplicated residue generator username web
    Given I am at the register new generator page
    When I fill the residue generator information with username "Los_Pollos"
    And username "Los_Pollos" has already been created
    And I register the new generator
    Then I see a error message

  Scenario: duplicated residue generator address
    Given The system has a generator with the address "Bubble Street number 7" already stored
    When I register a different generator of residue with the address "Bubble Street number 7"
    Then The new residue generator is not stored twice by the system

  Scenario: duplicated residue generator address web
    Given I am at the register new generator page
    When I fill the generator details with the address "Bubble Street number 7"
    And I register the new generator
    And I register a different generator with the address "Bubble Street number 7"
    Then I should see an error message

  Scenario: new incomplete residue generator
    Given The system has no generator with the address "Bubble Street number 8"
    When I register a new generator of residue with some info left incomplete
    And The address "Bubble Street number 8"
    Then The new residue generator is not stored by the system

  Scenario: new incomplete residue generator web
    Given I am at the register new generator page
    When I fill the generator details with some fields left incomplete
    And I register the new generator
    Then I should see an error message
