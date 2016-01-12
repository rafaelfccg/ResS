package steps

import pages.HarvestSolicitationViewPage
import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

import static cucumber.api.groovy.EN.*

//CONTROLLER

//Scenario: Sending confirmation
<<<<<<< HEAD
Given(~'^that the system has a waste collection confirmed$'){ String name ->
=======



Given(~'^that the system has a waste collection confirmed$'){->
>>>>>>> 8eed4c3c65d8afa6ab588d7f88ddd26fef8f4132
    CreateHarvestSolicitationTestDataAndOperations.createGeneratorByName(name)
    residueGenerator = ResidueGenerator.findByNameGenerator(name)

    assert residueGenerator != null && residueGenerator.hasActiveHarvest
}

When(~'^I submit the email request$') {

  CreateHarvestSolicitationTestDataAndOperations.createHarvestSolicitationByGenerator(residueGenerator)
    harvestSolicitation = HarvestSolicitation.findByResidueGenerator(residueGenerator)

    assert residueGenerator.harvestSolicitation != null && harvestSolicitation != null && harvestSolicitation.status == "Pending"
  
}
And(~'^There is internet connection$') { ->

//isn't implemented

}

Then(~'^the system sends an email confirmation for the registered stakeholders$') {

page.sendEmailConfirmation(restaurante)

}


//GUI

//Scenario: Send request confirmation


Given(~'^that I’m logged in the system$'){ 

//isn't implemented

}

And(~'I am on the page of collection confirmation$'){ ->

    to ConfirmaColetaViewPage
    at ConfirmaColetaViewPage
    
}
When(~'^I select the “Send email confirmation” button$') {

//isn't implemented

}

Then(~'^an email is delivered to the  relevant stakeholder $') {

//isn't implemented

}
And(~'^I see a success message$') {

    to ConfirmaColetaViewPage
    at ConfirmaColetaViewPage
    
    assert page.hasOk()
    
<<<<<<< HEAD
}
=======

}


>>>>>>> 8eed4c3c65d8afa6ab588d7f88ddd26fef8f4132
