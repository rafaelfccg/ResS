/**
 * Created by ess on 20/10/15.
 */
 /*
package steps

import pages.HarvestSolicitationViewPage
import residueGenerator.ResidueGenerator

//CONTROLLER



//Scenario: Report generation
Given(~'^that collections were made on "([^"]*)" residue generator on the last month$') { String name ->
    GeneratorTestDataAndOperations.createGeneratorName(name)
    residueGenerator = ResidueGenerator.findByNameGenerator(name)
    assert residueGenerator != null && GeneratorTestDataAndOperations.hasMonthlyHarvest(residueGenerator)
}
When(~'^the system receives a request to generate a report by "([^"]*)" residue generator$') { String name ->
    GeneratorTestDataAndOperations.createReport(residueGenerator)
    reportGenerator = ReportGenerator.findByNameGenerator(name)
}
Then(~'^a report is generated containing those collection’s information$') { ->
    assert reportGenerator != null
}

*/
//GUI
/*

//Scenario: Generate new report
Given(~'^I am at the HarvestSolicitationViewPage page$'){ ->
    to HarvestSolicitationViewPage
    at HarvestSolicitationViewPage
}



When(~'I select the "Generate Report" option$') { ->
    page.generateReport()

}

And(~'^collections were made on the previous month at "RU" residue generator$') { String name ->
	GeneratorTestDataAndOperations.createGeneratorByName(name)
    residueGenerator = ResidueGenerator.findByNameGenerator(name)
    assert residueGenerator != null && GeneratorTestDataAndOperations.hasMonthlyHarvest(residueGenerator)
}




Then(~'^I see the generated report$') { ->
	printRelatorio()
}*/

