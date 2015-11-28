package steps

import pages.CreateHarvestSolicitationPage
import pages.HarvestSolicitationViewPage
import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

import static cucumber.api.groovy.EN.*

Given (~'^the system has a waste collection solicitation by "([^"]*)" residue generator$') { String name ->

    CreateHarvestSolicitationTestDataAndOperations.createGeneratorByName(name)
    residueGenerator = ResidueGenerator.findByNameGenerator(name)

    assert residueGenerator != null && residueGenerator.hasActiveHarvest
}

And (~'^the solicitation is pending$') {

    CreateHarvestSolicitationTestDataAndOperations.createHarvestSolicitationByGenerator(residueGenerator)
    harvestSolicitation = HarvestSolicitation.findByResidueGenerator(residueGenerator)

    assert residueGenerator.harvestSolicitation != null && harvestSolicitation != null && harvestSolicitation.status == "Pending"
}

When (~'^I confirm the "([^"]*)" waste collection$') { String name ->

    harvestSolicitation.status == "Confirmed"
    residueGenerator.hasActiveHarvest == false
    residueGenerator.harvestSolicitation == null

}

Then (~'^the waste collection confirmation is registered$') {

    assert HarvestSolicitation.findByResidueGenerator(residueGenerator) != null && HarvestSolicitation.findByStatus("Confirmed") != null && HarvestSolicitation.findBySolicitationDate(harvestSolicitation.solicitationDate) != null

}


Given (~'^the system already has a waste collection solicitation by "([^"]*)" residue generator$') { String name ->

    CreateHarvestSolicitationTestDataAndOperations.createAlreadyCollectedGeneratorByName(name)
    residueGenerator = ResidueGenerator.findByNameGenerator(name)

    assert residueGenerator != null && !residueGenerator.hasActiveHarvest
}

And (~'^this solicitation is already confirmed$') {

    CreateHarvestSolicitationTestDataAndOperations.createConfirmedHarvestSolicitationByGenerator(residueGenerator)
    harvestSolicitation = HarvestSolicitation.findByResidueGenerator(residueGenerator)

    assert residueGenerator.harvestSolicitation == null && harvestSolicitation != null && harvestSolicitation.status == "Confirmed"
}

Then (~'^the confirmation do not overwrite the previous one$') {

    assert harvestSolicitation.solicitationDate <= newDate()

}


//GUI
Given(~'I am at HarvestSolicitationViewPage page$'){ ->
    to HarvestSolicitationViewPage
    at HarvestSolicitationViewPage
}

When(~'I select the "Confirm Collection" button$') { ->
    page.confirmCollection()
}

Then(~'I can see a confirmation message$') { ->
    assert withConfirm(true) { $("input", name: "areYouSure").click() } == "Você deseja confirmar a coleta?"

}

And(~'I can see the fields for making a new waste collection solicitation$') { ->
    to CreateHarvestSolicitationPage
    at CreateHarvestSolicitationPage

    assert page.title == "Criar solicitacao de coleta"

}

Then(~'I can see a warning message$') { ->
    assert withAlert { $("input", name: "alreadyConfirmed").click() } == "Essa coleta já foi confirmada."
}


