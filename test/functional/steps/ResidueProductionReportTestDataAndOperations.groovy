package steps

import residueGenerator.*

/**
 * Created by ess on 18/11/15.
 */
class ResidueProductionReportTestDataAndOperations {
    static  generators = [

            [nameGenerator:"RU",
             type: "Restaurante",
             cnpj: "testecnpj1",
             username: "Los_Pollos",
             password: "Abcd1234@",
             addressGenerator: "endereco",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"Clovis Palace",
             type: "Restaurante",
             cnpj: "testecnpj2",
             username: "Los_Pollos2",
             password: "Abcd1238@",
             addressGenerator: "endereco2",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"China Dragon",
             type: "Restaurante",
             cnpj: "testecnpj3",
             username: "Los_Pollos3",
             password: "Abcd1239@",
             addressGenerator: "Donut Street number 5",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"China Dragon",
             type: "Restaurante",
             cnpj: "testecnpj3",
             username: "Los_Pollos5",
             password: "Abcd1239@",
             addressGenerator: "Av. Capacanama",
             averageMonthlyMeals: 0,
             averageDailyMeals: 10]

    ]
    static public void getGeneratorByAddress(String address){
        generators.find{ generator ->
            generator.addressGenerator == address

        }
    }

    static public void createGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = getGeneratorByAddress(address)
        cont.params << novoGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

}
