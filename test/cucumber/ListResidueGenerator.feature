
Feature: List of Residue Generator
  As a Residue Collector
  I want to list and sort all Residue Generators
  so that I know all Residuo Generators and which Residue Generators are a priority


#if($list)
  Scenario: listing Residue Generators
    Given the system has a Residue Generator at "Av. Jequitiboca" in it
    When the system list all existing Residue Generators
    Then the system list contains "Av. Jequitiboca"

  Scenario: system sort list of existing Residue Generator by average daily meal
    Given the system has a Residue Generator at "Av. Capacanama" with average daily meal of "10"
    And the system has a Residue Generator at "Av. Brodewai" with average daily meal of "5"
    When I sort the list content by average daily meals
    Then the order of the system list have been modified to have address "Av. Capacanama" before "Av. Brodewai"
@ignore
  Scenario: reaching residue generator list page from the show page
    Given I am at the Residue Generator Show page
    When I go to the List Residue Generators page
    Then I am at the Residue Generator List page

  Scenario: sort by average daily meal
    Given I am at the Residue Generators List page
    When I sort by Average Daily Meal
    Then I am at the Residue Generators List page
    And the displayed list is sorted by Average Daily Meal
#end
