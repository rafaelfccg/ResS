/**
 * Created by ess on 18/11/15.
 */

package steps

import generatorProductionReport.GeneratorProductionReportController
import pages.GeneratorCreatePage
import pages.ResidueGeneratorShowPage
import pages.ResidueProductionReportPage
import residueGenerator.ResidueGenerator
import pages.CreateResidueProductionReportPage
import pages.ResidueProductionReportPage
import generatorProductionReport.GeneratorProductionReport

import static cucumber.api.groovy.EN.*

// Scenario: generate month based Residue Production report
//Given the system has a residue generator at “endereco” registered
//When the system generate the general production report for the last "5" months
//Then the residue generator at “endereco” appears at the report

Given(~'^the system has a residue generator at "([^"]*)" registered$'){ String address ->
    GeneratorTestDataAndOperations.createGenerator(address);

}

When(~'^the system generates an production report for the last "([^"]*)" months$') { int num ->
    // Express the Regexp above with the code you wish you had
    GeneratorProductionReportController controller = new GeneratorProductionReportController()
    report  = ProductionReportTestDataAndOperations.report
    ProductionReportTestDataAndOperations.setReport(num)
}
Then(~'^the residue generator at "([^"]*)" appears at the report$') { String address ->
    // Express the Regexp above with the code you wish you had
    //assert ResidueGenerator.findByAddressGenerator(address)
    report = ProductionReportTestDataAndOperations.getReport()
    assert report.hasGenerator(address)
}

Then(~'^nothing has been changed$') { ->
   // check every Harvest solicitation AND Residue generator?

}
//  Scenario: generate empty month based Residue Production report
//Given the system has no registered residue Generator
//When the system generates an production report for the last "5" months
//Then then report is empty

Given(~'^the system has no registered residue Generator'){->
    ResidueGenerator.deleteAll(ResidueGenerator.findAll())
}

Then(~'^then report is empty'){->
    report.isEmpty()
}

//  Scenario: generate month based Residue Production report web
//Given I am at the Residue Generator Report page
//When I click ask the system to produce a report based on the last "5" months
//Then I am at the Report Waste Production page

Given(~'^I am at the Create Residue Generator Report page'){->
    to CreateResidueProductionReportPage
    at CreateResidueProductionReportPage

}
When(~'^I click ask the system to produce a report based on the last "([^"]*)" months'){String months->
    at CreateResidueProductionReportPage
    page.fillPeriod(months)
    page.clickNewMonthlyReport()
}
Then(~'^I am at the Report Waste Production page'){->
    at ResidueProductionReportPage
}

// Scenario: generate empty month based Residue Production report web
//Given I am at the Residue Generator Report page
//And the system has no registered residue Generator
//When I click ask the system to produce a report based on the last "5" months
//Then I am at the Report Waste Production page
//And the report is empty

And(~'^the report is empty'){->
    assert page.hasEmptyMessage()
}

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
