Feature: Notification of waste collection confirmation
  As an employee
  I want the system to send a confirmation of waste collection by email
  So the city hall and the researcher be informed that collection has been successful


#CONTROLLER
  @ignore
  Scenario: sending confirmation
    Given that the system has a waste collection confirmed
    And there is internet connection
    When I submit the email request
    Then the system sends an email confirmation for the registered stakeholders
  @ignore
  Scenario: failure confirmation sending
    Given   that the system has a waste collection confirmed
    And there isn’t internet connection
    When the system tries to send an email confirmation
    Then the system generetes an error notification 
    And the system saves the emails to be sent when there is internet connection

#GUI
  @ignore
  Scenario: send request confirmation
    Given that I’m logged in the system
    And I’m on collection confirmation screen
    When I select the “Send email confirmation” option
    Then an email is delivered to the  relevant stakeholder
    And I see a success message

@ignore
  Scenario: failure sending confirmation
    Given that I’m logged in the system
    And I’m on collection confirmation screen
    When I select the “Send email confirmation” option
    Then I see a failure warning message
