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

//@ignore
// Scenario: export Residue Production report as CSV
//Given I have a residue production report
//When I ask the system to export the report into a csv with name "relatorio.csv" and path "~\Downloads"
//Then The system saves a file to my computer

Given(~'I have a residue production report'){->
    ProductionReportTestDataAndOperations.setReport(5)
}

When(~'I ask the system to export the report into a csv with name "([^"]*)" and path "([^"]*)"'){String name, String path->
    ProductionReportTestDataAndOperations.getReport().saveCSV(name,path);
    checkPath = path+"\\"+name
}

Then(~'The system saves a file to my computer'){->
    File f = new File(checkPath)
    assert f.exists()
}


//@ignore
//        Scenario: fail to export Residue Production report as CSV
//Given I have a residue production report
//When I ask the system to export the report into a csv with name "relatorio.csv" and path "~\AAss"
//And the path "~\AAss" does not exists
//Then The system doesnt save the file to my computer

And(~'the path "([^"]*)" does not exists'){String path ->
    File f = new File(path)
    assert !f.exists()
}
Then(~'The system doesnt save the file to my computer'){->
    File f = new File(checkPath)
    assert !f.exists()
}
//@ignore
//Scenario: export Residue Production report as CSV web
//Given I am at the residue production report page
//When I select the option to export the report into a csv with name "relatorio.csv" and path "~\Downloads"
//Then I see a confirmation that the file was saved
//@ignore

Given(~'I am at the residue production report page'){->
    to CreateResidueProductionReportPage
    page.fillPeriod(5)
    page.clickNewMonthlyReport()
    at ResidueProductionReportPage
}
When(~'I select the option to export the report into a csv with name "([^"]*)" and path "([^"]*)"'){String name, String path->
    page.clickExportCSV(name,path)
}

Then(~'I see a confirmation that the file was saved'){->

}
// Scenario: fail to export Residue Production report as CSV web
//Given I am at the residue production report page
//When I select the option to export the report into a csv with name "relatorio.csv" and path "~\AAss"
//And the path "~\AAss" does not exists
//Then I see an error about the exporting file
