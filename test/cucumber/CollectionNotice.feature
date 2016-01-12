Feature: Collection notice
  As an employee of a restaurant
  I want the system to send a notification via email to the city hall about the need for collection
  So I can keep the profile of the city hall and the researcher informed  about such a need

#Controller
@ignore
  Scenario: Resend email Notification
    Given that the system receives a request by "Lol" for an email to be resent
    When the system confirms that there are pending requests
    Then the system resends the email with the data of the pending requests to the city hall and the researcher
    And generates a notification of email sending confirmation
@ignore
  Scenario: Failure resending Notification
    Given that the system receives a request for an email to be resent
    When the system confirms that there are pending requests
    Then the system does not resend the email with the data of the pending requests
    And generates an error notification

#GUI
@ignore
  Scenario: Resending email Notification
    Given I am on the page of requested collections
    And there has been a open collection request for some time
    When I select the resend email notification option
    Then I see a confirmation message
@ignore
  Scenario:  Failure resending email Notification
    Given I am on the page of requested collections
    And there has been a open collection request for some time
    When I select the resend email notification option
    Then I see an error message
