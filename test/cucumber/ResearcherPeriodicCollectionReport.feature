#if($ResearcherPeriodicCollectionReport)
Feature: Generation of Periodic Collection Report of the whole system
As a researcher
I want to generate a report
So I can see the volume of collections made on a specific month 

#CONTROLLER

Scenario: Report generation
Given that collections were made on at least one residue generator on month "11" 
When the system receives a request to generate a report by a researcher user
Then a report is generated containing information on the collections made on month "11" 


Scenario: Error in report generation
Given no collections were made on any residue generator on month "12" 
When the system receives a request for a report to a researcher user
Then an error is sent to the user

#GUI


Scenario: Generate new report
Given I am at the Coletas page
When I select the date range
And I select "Gerar Relatorio" option
Then I see the generated report

@ignore
Scenario: Generate empty report
Given I am at the HarvestSolicitationViewPage page
When I select the "Generate Report" option
And no collections were made on the previous month at "RU" residue generator
Then I see an empty report error message
And no report is shown




#end