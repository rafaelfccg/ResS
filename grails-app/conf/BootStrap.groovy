import harvestCompany.HarvestCompany
import residueGenerator.ResidueGenerator

class BootStrap {

    def init = { servletContext ->
        def ru = new ResidueGenerator(
                nameGenerator:"RU",
                type: "Restaurante",
                cnpj: "12345678910005",
                password: "12345678",
                addressGenerator: "Bubble road number 4",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )



        def stockHarvestCompany1 = new HarvestCompany(name: "Garbage Co")
        def stockHarvestCompany2 = new HarvestCompany( name: "Reciclatron")
        def stockHarvestCompany3 = new HarvestCompany( name: "Clean Planet")

        def stockResidueGenerator = new ResidueGenerator(
                nameGenerator: "Stock Food",
                type: "Restaurante",
                cnpj: "12345678912300",
                addressGenerator: "Elm Street number 13",
                averageDailyMeals: 30,
                averageMonthlyMeals: 1000,
                hasActiveHarvest: false,
                harvestSolicitation: null
        )

        def stockResidueGenerator2 = new ResidueGenerator(
                nameGenerator: "Nuka Cola",
                type: "Restaurante",
                cnpj: "12345678912111",
                addressGenerator: "Elm Street number 14",
                averageDailyMeals: 20,
                averageMonthlyMeals: 1000,
                hasActiveHarvest: false,
                harvestSolicitation: null
        )



        ru.save(failOnError: true)
        stockResidueGenerator.save(failOnError: true)
        stockResidueGenerator2.save(failOnError: true)
        stockHarvestCompany1.save(failOnError: true);
        stockHarvestCompany2.save(failOnError: true);
        stockHarvestCompany3.save(failOnError: true);

        def area2 = new ResidueGenerator(
                nameGenerator:"CCEN/�rea II",
                type: "Cantina",
                cnpj: "12345678912347",
                addressGenerator: "UFPE1",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        area2.save(failOnError: true)

        def bomCafe = new ResidueGenerator(
                nameGenerator:"Bom Caf� � CTG",
                type: "Restaurante",
                cnpj: "12345678912348",
                addressGenerator: "UFPE2",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        bomCafe.save(failOnError: true)
        def rotadoLanche = new ResidueGenerator(
                nameGenerator:"Rota do Lanche",
                type: "Restaurante",
                cnpj: "12345678912853",
                addressGenerator: "UFPE3",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        rotadoLanche.save(failOnError: true)

        def cantinaCssa = new ResidueGenerator(
                nameGenerator:"Cantina CCSA",
                type: "Cantina",
                cnpj: "12345678910483",
                addressGenerator: "UFPE4",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        cantinaCssa.save(failOnError: true)
        def quiosqueCssa = new ResidueGenerator(
                nameGenerator:"Quiosque CCSA",
                type: "Cantina",
                cnpj: "12345654612345",
                addressGenerator: "UFPE5",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        quiosqueCssa.save(failOnError: true)

        def planetRefeicoesCTG = new ResidueGenerator(
                nameGenerator:"Planet Refei��es � CTG",
                type: "Restaurante",
                cnpj: "12098374651029",
                addressGenerator: "UFPE6",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        planetRefeicoesCTG.save(failOnError: true)

        def planetRefeicoesCCS = new ResidueGenerator(
                nameGenerator:"Planet Refei��es � CCS",
                type: "Restaurante",
                cnpj: "10294758493028",
                addressGenerator: "UFPE7",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        planetRefeicoesCCS.save(failOnError: true)
        def planetRefeicoesCE = new ResidueGenerator(
                nameGenerator:"Planet Refei��es � CE",
                type: "Restaurante",
                cnpj: "01929292837465",
                addressGenerator: "UFPE8",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        planetRefeicoesCE.save(failOnError: true)
        def chefPlataoCCSA = new ResidueGenerator(
                nameGenerator:"Chef Plat�o � CCSA",
                type: "Restaurante",
                cnpj: "10293839201928",
                addressGenerator: "UFPE9",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )

        chefPlataoCCSA.save(failOnError: true)

        def chefPlataoCFCH = new ResidueGenerator(
                nameGenerator:"Chef Plat�o � CFCH",
                type: "Restaurante",
                cnpj: "12345678912345",
                addressGenerator: "UFPE10",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        chefPlataoCFCH.save(failOnError: true)
        def aquarela = new ResidueGenerator(
                nameGenerator:"Aquarela - CAC",
                type: "Restaurante",
                cnpj: "12300008912345",
                addressGenerator: "UFPE11",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        aquarela.save(failOnError: true)

        def sinhaPimenta = new ResidueGenerator(
                nameGenerator:"Sinh� Pimenta � CCB",
                type: "Restaurante",
                cnpj: "12345670002345",
                addressGenerator: "UFPE12",
                averageMonthlyMeals: 0,
                averageDailyMeals: 0
        )
        sinhaPimenta.save(failOnError: true)

    }
    def destroy = {
    }
}
