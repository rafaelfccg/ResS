Feature: Residue Generator Production Report
  As a researcher
  I want visualize the waste production of the residue generators
  So I can collect data for my research

@ignore
  Scenario: generate month based Residue Production report
  Given the system has a residue generator at "endereco" registered
  When the system generates an production report for the last "5" months
  Then the residue generator at "endereco" appears at the report
  And nothing has been changed
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


  @ignore
  Scenario: export Residue Production report as CSV
    Given I have a residue production report
    When I ask the system to export the report into a csv with name "relatorio.csv" and path "~\Downloads"
    Then The system saves a file to my computer
  @ignore
  Scenario: fail to export Residue Production report as CSV
    Given I have a residue production report
    When I ask the system to export the report into a csv with name "relatorio.csv" and path "~\AAss"
    And the path "~\AAss" does not exists
    Then The system doesnt save the file to my computer
  @ignore
  Scenario: export Residue Production report as CSV web
    Given I am at the residue production report page
    When I select the option to export the report into a csv with name "relatorio.csv" and path "~\Downloads"
    Then I see a confirmation that the file was saved
  @ignore
  Scenario: fail to export Residue Production report as CSV web
    Given I am at the residue production report page
    When I select the option to export the report into a csv with name "relatorio.csv" and path "~\AAss"
    And the path "~\AAss" does not exists
    Then I see an error about the exporting file
  @ignore
  Scenario: generate historical month based residue production report
    Given the system has a residue generator at "endereco" registered
    When the system receives a request to generate an annual residue generator production report for a period of "3" years for that month
    Then a report with average data and comparison for that month and years is generated
  @ignore
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
     And the report has no data available
