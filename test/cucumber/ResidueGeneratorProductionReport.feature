Feature: Residue Generator Production Report
  As a researcher
  I want visualize the waste production of the residue generators
  So I can collect data for my research


  Scenario: generate month based Residue Production report
  Given the system has a residue generator at "endereco" registered
  When the system generates an production report for the last "5" months
  Then the residue generator at "endereco" appears at the report
  And nothing has been changed

  Scenario: generate empty month based Residue Production report
    Given the system has no registered residue Generator
    When the system generates an production report for the last "5" months
    Then the report is empty

  Scenario: generate month based Residue Production report web
    Given I am at the Create Residue Generator Report page
    When I click ask the system to produce a report based on the last "5" months
    Then I am at the Report Waste Production page


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
