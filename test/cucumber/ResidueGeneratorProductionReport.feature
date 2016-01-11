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
    Then the report is empty

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

  Scenario: generate historical month based residue production report
    Given the system has a residue generator at "endereco" registered
    When the system receives a request to generate an annual residue generator production report for a period of "3" years for that month
    Then a report with average data and comparison for that month and years is generated

  Scenario: generate empty historical month based residue production report
    Given the system has no registered residue Generator
    When the system receives a request to generate an annual residue generator production report for a period of "3" years for that month
    Then the report has no data available

  @ignore
  Scenario: generate historical month based residue production report web
     Given I am at the Create Residue Generator Report page
     When I select the button to generate the report
     And I fill the type and period fields correctly
     Then I am at the Report Waste Production page

  @ignore
  Scenario: generate empty historical month based residue production report web
     Given I am at the Create Residue Generator Report page
     And the system has no registered residue Generator
     When I select the button to generate the report
     And I fill the type and period fields correctly
     Then I am at the Report Waste Production page
     And the report is empty
