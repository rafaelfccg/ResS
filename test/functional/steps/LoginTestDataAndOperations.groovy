package steps

import residueGenerator.ResidueGenerator
import residueGenerator.ResidueGeneratorController


class LoginTestDataAndOperations {


    static  generators = [

            [nameGenerator:"LosPolos",
             type: "Restaurante",
             cnpj: "12345678904567",
             password: "345" ,
             addressGenerator: "Bubble Street number 7",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0]

    ]


    static public def findGeneratorByName(String name) {
        generators.find { generator ->
            generator.nameGenerator == name
        }
    }

    static public def findGeneratorByPassword(String pass) {
        generators.find { generator ->
            generator.password == pass
        }
    }

    static public def findGeneratorByCNPJ(String cnpj) {
        generators.find { generator ->
            generator.cnpj == cnpj
        }
    }

    static public def logar(String pass){

            def user = findGeneratorByPassword(pass)

            if (user)
               true

            else
                false

    }

    static public void createGeneratorUsername(String username){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: "Los Polos",
                            type: "Restaurante",
                            cnpj: "00000000000001",
                            username: username,
                            password: "345",
                            addressGenerator: "Bubble Street number 7",
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
    }

}
