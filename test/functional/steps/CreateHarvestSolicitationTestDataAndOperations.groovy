package steps

import residueGenerator.ResidueGenerator
import residueGenerator.HarvestSolicitation
import residueGenerator.GeneratorHarvestSolicitationController
import residueGenerator.ResidueGeneratorController

class CreateHarvestSolicitationTestDataAndOperations {

    static generators = [
            [
                    nameGenerator: "Nuka Cola",
                    type: "Restaurante",
                    cnpj: "0000000",
                    addressGenerator: "Elm Street number 13",
                    averageDailyMeals: 30,
                    averageMonthlyMeals: 1000,
                    hasActiveHarvest: true,
                    harvestSolicitation: null
            ],

            [
                    nameGenerator: "RU",
                    type: "Restaurante",
                    cnpj: "0000000",
                    addressGenerator: "Any Street number 5",
                    averageDailyMeals: 50,
                    averageMonthlyMeals: 2000,
                    hasActiveHarvest: true,
                    harvestSolicitation: findHarvestByGeneratorName("RU")
            ],

            [
                    nameGenerator: "RU",
                    type: "Restaurante",
                    cnpj: "0000000",
                    addressGenerator: "Any Street number 5",
                    averageDailyMeals: 50,
                    averageMonthlyMeals: 2000,
                    hasActiveHarvest: false,
                    harvestSolicitation: null
            ]
    ]



    static harvestSolicitations = [
            [
                    harvesterId:3,
                    generatorId:2,
                    status: "Pending",
                    estimatedAmountOfResidue: 30,
                    solicitationDate: new Date(),
                    residueGenerator: findGeneratorByAddress("Elm Street number 13")
            ],

            [
                    harvesterId: 3,
                    generatorId: 1,
                    status: "Pending",
                    estimatedAmountOfResidue: 60,
                    solicitationDate: new Date(),
                    residueGenerator: findGeneratorByName("RU")
            ],

            [
                    harvesterId: 3,
                    generatorId: 1,
                    status: "Confirmed",
                    estimatedAmountOfResidue: 60,
                    solicitationDate: new Date(),
                    residueGenerator: findGeneratorByName("RU")
            ]
    ]


    static public def findGeneratorByAddress(String address) {
        generators.find { generator ->
            generator.addressGenerator == address
        }
    }

    static public def findGeneratorByName(String name) {
        generators.find { generator ->
            if(generator.nameGenerator == name) {

                generator.hasActiveHarvest == true

            }
        }

    }

    static public def findAlreadyCollectedGeneratorByName(String name) {
        generators.find { generator ->
            if(generator.nameGenerator == name) {

                generator.hasActiveHarvest == false

            }
        }

    }

    static public def findHarvestByAmount(String amount) {
        int amountNumber =  amount.toInteger();
        harvestSolicitations.find { harvest ->
            harvest.estimatedAmountOfResidue == amountNumber
        }
    }

    static public def findHarvestByGeneratorName(String name) {
        harvestSolicitations.find { harvest ->
            if (harvest.residueGenerator.nameGenerator == name) {

                harvest.status == "Pending"

            }
        }

    }

    static public def findConfirmedHarvestByGeneratorName(String name) {
        harvestSolicitations.find { harvest ->
            if(harvest.residueGenerator.nameGenerator == name) {

                harvest.status == "Confirmed"

            }

        }

    }

    static public void createGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = findGeneratorByAddress(address)
        cont.params << novoGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void createGeneratorByName (String name) {

        def controller = new ResidueGeneratorController()
        def newGenerator = findGeneratorByName(name)
        controller.params << newGenerator
        controller.create()
        controller.save()
        controller.response.reset()
    }

    static public void createAlreadyCollectedGeneratorByName (String name) {
        def controller = new ResidueGeneratorController()
        def newGenerator = findAlreadyCollectedGeneratorByName(name)
        controller.params << newGenerator
        controller.create()
        controller.save()
        controller.response.reset()
    }

    static public void createHarvestSolicitation(String amount){
        def cont = new GeneratorHarvestSolicitationController()
        def newHarvest = findHarvestByAmount(amount)
        cont.params << newHarvest
        cont.save()
        cont.response.reset()
    }

    static public void createHarvestSolicitationByGenerator(ResidueGenerator residueGenerator) {
        def controller = new GeneratorHarvestSolicitationController()
        def newHarvest = findHarvestByGeneratorName(residueGenerator.nameGenerator)
        controller.params << newHarvest
        controller.save()
        controller.response.reset()
    }

    static public void createConfirmedHarvestSolicitationByGenerator(ResidueGenerator residueGenerator) {
        def controller = new GeneratorHarvestSolicitationController()
        def newHarvest = findConfirmedHarvestByGeneratorName(residueGenerator.nameGenerator)
        controller.params << newHarvest
        controller.save()
        controller.response.reset()
    }

}
