package steps

import residueGenerator.ResidueGenerator
import residueGenerator.HarvestSolicitation
import residueGenerator.GeneratorHarvestSolicitationController
import residueGenerator.ResidueGeneratorController

class SolicitacaoColetaTestDataAndOperations {

    static generators = [
            [
                    nameGenerator: "Nuka Cola",
                    type: "Restaurante",
                    cnpj: "0000000",
                    username: "username",
                    password: "password",
                    addressGenerator: "Elm Street number 13",
                    averageDailyMeals: 30,
                    averageMonthlyMeals: 1000,
                    hasActiveHarvest: true,
                    harvestSolicitation: null
            ],

            [
                    nameGenerator: "Lol",
                    type: "Restaurante",
                    cnpj: "0000000",
                    username: "username",
                    password: "password",
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
                    username: "username",
                    password: "password",
                    addressGenerator: "Any Street number 5",
                    averageDailyMeals: 50,
                    averageMonthlyMeals: 2000,
                    hasActiveHarvest: false,
                    harvestSolicitation: findHarvestByGeneratorName("RU")
            ]
    ]



    static harvestSolicitations = [
            [
                    harvesterId:3,
                    generatorId:2,
                    status: "Pending",
                    estimatedAmountOfResidue: 30,
                    solicitationDate: new Date(),
                    confirmationDate: null,
                    residueGenerator: findGeneratorByAddress("Elm Street number 13")
            ],

            [
                    harvesterId: 3,
                    generatorId: 1,
                    status: "Pending",
                    estimatedAmountOfResidue: 60,
                    solicitationDate: new Date(),
                    confirmationDate: null,
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
            generator.nameGenerator == name
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
            harvest.residueGenerator.nameGenerator == name
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


}
