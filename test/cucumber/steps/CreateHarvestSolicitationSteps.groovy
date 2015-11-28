package steps

import pages.CreateHarvestSolicitationPage
import pages.HarvestSolicitationViewPage
import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

import static cucumber.api.groovy.EN.*

Given(~'^there is no active harvest solicitation for the generator which address is "([^"]*)"$'){String address ->
    CreateHarvestSolicitationTestDataAndOperations.createGenerator(address)
    generator = ResidueGenerator.findByAddressGenerator(address)
    assert generator != null && generator.hasActiveHarvest == false
}

When(~'^I submit the harvest solicitation with "([^"]*)" litre of residue$'){ String amount ->
    keepAmount = amount
    CreateHarvestSolicitationTestDataAndOperations.createHarvestSolicitation(amount)
}

Then(~'the system should store the solicitation$'){ ->
    assert HarvestSolicitation.findByEstimatedAmountOfResidue(keepAmount) != null
}


//----------------------------------------- GUI TESTS -------------------------------------------

Given(~'I am at the harvest solicitation creation page$'){ ->
    to CreateHarvestSolicitationPage
    at CreateHarvestSolicitationPage
}

When(~'I fill the amount of residue field with "([^"]*)"$'){String amount ->
    page.fillAmountField(amount)
}

And(~'fill the other required fields$'){ ->
    page.fillRequiredFields()
}

And(~'submit the fields'){ ->
    page.submitChanges()
}

Then(~'I should see the new harvest solicitation on the solicitation page$'){ ->
    to HarvestSolicitationViewPage
    at HarvestSolicitationViewPage
    assert page.hasLabel() == true
}