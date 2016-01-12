
Feature: Request a new residue collection at a restaurant
As a restaurant owner
I want to be able to request a residue collection
So I can have my residue collected when I need


#Created by Ricardo Barioni
#Modified by Ricardo Barioni

#Controller
Scenario: Blank Name input
Given I am logged in the system as a restaurant
When I register a residue collection request with Name ""
Then The residue request with name "" is not generated

Scenario: Invalid volume input
Given I am logged on the system as a restaurant
When I register a residue collection request with Volume "0"
Then The residue request with volume "0" is not created

#-----

Scenario: Positive volume and valid password input
Given I am logged in the system as restaurant
When I register a residue collection request with Volume "20" and password "123456"
Then The residue request with Volume "20" and password "123456" is generated

Scenario: Negative volume and valid password input
Given I am logged on the system as restaurant
When I register a new residue collection request with Volume "-20" and password "123456"
Then The residue request with Volume "-20" and password "123456" is not generated

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

#-----

Scenario: Positive volume and valid password input
Given I am at the creating collection page
When I fill the request information with Volume "20" and password "123456"
And Fill name and data fields
And I Select "Create"
Then I should not see a error message

Scenario: Negative volume and valid password input
Given I am on the creating collection page
When I fill the new request information with Volume "-20" and password "123456"
And Fill the name and data fields
And I Choose "Create"
Then I shall see a error message
