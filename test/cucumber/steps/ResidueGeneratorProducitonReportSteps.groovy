/**
 * Created by ess on 18/11/15.
 */

package steps

import pages.GeneratorCreatePage
import pages.ResidueGeneratorShowPage
import residueGenerator.ResidueGenerator
import generatorProductionReport.GeneratorProductionReport

import static cucumber.api.groovy.EN.*

//@ignore
// Scenario: generate month based Residue Production report
//Given the system has a residue generator at “endereco” registered
//When the system generate the general production report for the last "5" months
//Then the residue generator at “endereco” appears at the report

Given(~'')


//@ignore
//  Scenario: generate empty month based Residue Production report
//Given the system has no registered residue Generator
//When the system generates an production report for the last "5" months
//Then then report is empty
//@ignore
//  Scenario: generate month based Residue Production report web
//Given I am at the Residue Generator Report page
//When I click ask the system to produce a report based on the last "5" months
//Then I am at the Report Waste Production page
//@ignore
// Scenario: generate empty month based Residue Production report web
//Given I am at the Residue Generator Report page
//And the system has no registered residue Generator
//When I click ask the system to produce a report based on the last "5" months
//Then I am at the Report Waste Production page
//And the report is empty

When (~'^the system receives a request to generate the residue generator production report for the month of "([^"]*)" for the last "([^"]*)" years$') { String month, int yearsAgo ->

    //to do

}

Then (~'^a report with data for that month and years is generated$') { ->

    //to do

}

When(~'I select the generate report button$') { ->

    //to do

}

And(~'I fill the required fields correctly$') { ->

    //to do

}

Then (~'^I am at the Historical Month Report Waste Production page$') { ->

    //to do

}


