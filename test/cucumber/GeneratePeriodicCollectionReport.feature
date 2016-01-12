#if($GeneratePeriodicCollectionReport)
Feature: Generation of Periodic Collection Report of a Specific Location
As a restaurant owner
I want to generate a report
So I can see the collections made on the last month  			



#GUI


@ignore
Scenario: Generate new report
Given I am at the HarvestSolicitationViewPage page
When I select the "Generate Report" option
And collections were made on the previous month at "RU" residue generator
Then I see the generated report

@ignore
Scenario: Generate empty report
Given I am at the HarvestSolicitationViewPage page
When I select the "Generate Report" option
And no collections were made on the previous month at "RU" residue generator
Then I see an empty report error message
And no report is shown

#CONTROLLER


@ignore


Scenario: Report generation
Given that collections were made on "RU" residue generator on the last month
When the system receives a request to generate a report by "RU" residue generator
Then an report is generated containing those collections’s information
@ignore
Scenario: Empty report generation
Given no collections were made on "RU" residue generator on the last month
When the system receives a request to generate a report by "RU" residue generator
Then a empty report message is generated
#end
