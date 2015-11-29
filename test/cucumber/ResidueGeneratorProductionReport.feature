Feature: Residue Generator Production Report
  As a researcher
  I want visualize the waste production of the residue generators
  So I can collect data for my research

  @ignore
  Scenario: generate month based Residue Production report
  Given the system has a residue generator at "endereco" registered
  When the system generates an production report for the last "5" months
  Then the residue generator at "endereco" appears at the report

  @ignore
  Scenario: generate empty month based Residue Production report
    Given the system has no registered residue Generator
    When the system generates an production report for the last "5" months
    Then then report is empty
  
  @ignore
  Scenario: generate month based Residue Production report web
    Given I am at the Create Residue Generator Report page
    When I click ask the system to produce a report based on the last "5" months
    Then I am at the Report Waste Production page
  @ignore
  Scenario: generate empty month based Residue Production report web
    Given I am at the Create Residue Generator Report page
    And the system has no registered residue Generator
    When I click ask the system to produce a report based on the last "5" months
    Then I am at the Report Waste Production page
    And the report is empty