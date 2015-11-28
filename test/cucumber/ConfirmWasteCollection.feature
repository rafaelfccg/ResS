Feature: Confirmation of waste collection
As a residue generator
I want to confirm the collection of my waste
So the other stakeholders can access this information

#if ($confirmationWasteCollection)
  @ignore
Scenario: Confirmation of pending waste collection
Given the system has a waste collection solicitation by “RU” residue generator
And the solicitation is pending
When I confirm the “RU” waste collection
Then the waste collection confirmation is registered

  @ignore
Scenario: Confirmation of a already confirmed waste collection
Given the system already has a waste collection solicitation by “RU” residue generator
And this solicitation is already confirmed
When I confirm the “RU” waste collection
Then the confirmation do not overwrite the previous one

  @ignore
Scenario: Confirmation of pending waste collection on the ResS web system
Given I am at the HarvestSolicitationViewPage page
When I select the "Confirm Collection" button
Then I can see a confirmation message
And I can see the fields for making a new waste collection solicitation

  @ignore
Scenario: Confirmation of a already confirmed waste collection on the ResS web system
Given I am at the "Waste Collection Solicitation List" page
When I select the "Confirm Collection" button
Then I can see a warning message
And I can see the fields for making a new waste collection solicitation
#end