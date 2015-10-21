Feature: Collection notice
	As an employee of a restaurant
	I want the system to send a notification via email to the city hall about the need for collection
	So I can keep the profile of the city hall and the researcher informed  about such a need

#Controller

  Scenario: Resend email Notification
	Given that the system receives a request for an email to be resent
	When the system confirms that there are pending requests
	And there is internet connection
	Then the system resends the email with the data of the pending requests to the city hall and the researcher
	And generates a notification of email sending confirmation

Scenario: Failure resending Notification
	Given that the system receives a request for an email to be resent
	When the system confirms that there are pending requests
	And there is no internet connection
	Then the system does not resend the email with the data of the pending requests
	And generates an error notification

#GUI

Scenario: Resending email Notification
	Given that I am logged into the restaurant account in which I work
	And I'm on the page of requested collections
	And there has been a open collection request for some time
	When I select the resend email notification option
	And I have internet connection
	Then I see a confirmation message
	And the email is resent

Scenario:  Failure resending email Notification
	Given that I'm logged in the account of the restaurant in which I work
	And I'm on the page of requested collections
	And there has been a open collection request for some time
	And I do not have internet connection
	When I select the resend email notification option
	Then I see an error message
	And the e-mail is not sent
