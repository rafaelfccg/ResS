
Feature: Request a new residue collection at a restaurant
As a restaurant owner
I want to be able to request a residue collection
So I can have my residue collected when I need


#Created by Ricardo Barioni


#Controller
Scenario: Blank Name input
Given I am logged in the system as a restaurant
When I register a residue collection request with Name ""
Then The residue request with name "" is not generated

Scenario: Invalid volume input
Given I am logged on the system as a restaurant
When I register a residue collection request with Volume "0"
Then The residue request with volume "0" is not created


#GUI
Scenario: Blank Name input
Given I am at creating collection page
When I fill the request information with Name ""
And I fill data and volume fields
And Choose "Create"
Then I should see a error message

Scenario: Invalid volume input
Given I am on creating collection page
When I fill the request information with Name "RU"
And I fill name and data fields
And Select "Create"
Then I see an error message

