Feature: Notification of waste collection confirmation
  As an employee
  I want the system to send a confirmation of waste collection by email
  So the city hall and the researcher be informed that collection has been successful


#CONTROLLER
  @ignore
  Scenario: sending confirmation
    Given that the system has a waste collection confirmed
    When I submit the email request
    And there is internet connection
    Then the system sends an email confirmation for the registered stakeholders
  @ignore
  Scenario: failure confirmation sending
    Given   that the system has a waste collection confirmed
    When there isn’t internet connection
    Then the system does not send an email confirmation
    And generetes an error notification


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
