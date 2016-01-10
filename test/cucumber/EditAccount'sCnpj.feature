Feature: Edit account's cnpj
  As a generator's owner
  I want to correctly edit my cnpj
  So that I can keep the system updated

#if($EditGeneratorCnpj)
  @tagQualquer
  Scenario: Correctly edit the cnpj
    Given the system has a residue generator with cnpj "12345678912345"
    When I change my cnpj to "45912367834512"
    Then the generator with cnpj "45912367834512" is properly edited


  @tagQualquer
  Scenario: Incorrectly edit the cnpj
    Given the system has a residue generator with cnpj "12345678912345"
    When I change my cnpj to "testecnpj"
    Then the generator with cnpj "testecnpj" is not edited

  @tagQualquer
  Scenario: Correctly edit the cnpj web
    Given I am at the residue generator edit page
    When I fill the cnpj field with "45912367834512"
    And I update my changes
    Then I can see that the storing was confirmed


  @tagQualquer
  Scenario: Incorrectly edit the cnpj web
    Given I am at the residue generator edit page
    When I fill the cnpj field with "testecnpj"
    And I update my changes
    Then I can see a error message
#end
