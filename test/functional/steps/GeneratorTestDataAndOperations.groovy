package steps

import residueGenerator.ResidueGenerator
import residueGenerator.ResidueGeneratorController

class GeneratorTestDataAndOperations{

    static  generators = [

            [nameGenerator:"RU",
             type: "Restaurante",
             cnpj: "testecnpj1",
             username: "Los_Pollos9",
             password: "Abcd1234@",
             addressGenerator: "Bubble Street number 7",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0],

            [nameGenerator:"Clovis Palace",
             type: "Restaurante",
             cnpj: "testecnpj2",
             username: "Los_Pollos2",
             password: "Abcd1238@",
             addressGenerator: "Bubble Street number 4",
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

            [nameGenerator:"Los Polos",
             type: "Restaurante",
             cnpj: "testecnpj1",
             password: "345" ,
             addressGenerator: "Bubble Street number 7",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0]

    ]

    static public def getGenerator(){
        return getGeneratorByAddress("Bubble Street number 7")
    }
    static public def findAllGeneratorByUsername(String username){
        return ResidueGenerator.findAllByUsername(username)
    }
    static public def findGeneratorByUsername(String username){
        return ResidueGenerator.findByUsername(username)
    }
    static public def findGeneratorByAddress(String address){
        return ResidueGenerator.findByAddressGenerator(address)
    }
    static public def findGeneratorByName(String name){
        return ResidueGenerator.findByNameGenerator(name)
    }
    static public def findGeneratorByCnpj(String cnpj){
        return ResidueGenerator.findByCnpj(cnpj)
    }

    static public def getGeneratorByAddress(String address) {
        generators.find { generator ->
            generator.addressGenerator == address
        }
    }
    static public def getGeneratorByUsername(String username) {
        generators.find { generator ->
            generator.username == username
        }
    }
    static public void getGeneratorByName(String name){
        generators.find {generator ->
                generator.nameGenerator == name
        }
    }
    static public void getGeneratorByCnpj(String CNPJ){
        generators.find {generator ->
            generator.cnpj== CNPJ
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

    static public void createGeneratorName(String name){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: name,
                            type: "Restaurante",
                            cnpj: "testecnpj1",
                            username: "Los_Pollos5",
                            password: "@Abcd1234",
                            addressGenerator: "Bubble Street number 7",
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void createGeneratorCnpj(String CNPJ){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: "RUcnpj",
                            type: "Restaurante",
                            cnpj: CNPJ,
                            username: "Los_Pollos6",
                            password: "@Abcd1234",
                            addressGenerator: "Bubble Street number 7",
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }
    static public void createGeneratorUsernamePasswordAddress(String username, String password, String address ){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: "RU",
                            type: "Restaurante",
                            cnpj: "testecnpj2",
                            username: username,
                            password: password,
                            addressGenerator: address,
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }
    static public void createGeneratorUsername(String username){
        def cont = new ResidueGeneratorController()
        def newGenerator = [nome: "RU",
                            type: "Restaurante",
                            cnpj: "testecnpj2",
                            username: username,
                            password: "@Abcd1234",
                            addressGenerator: "Bubble Street number 7",
                            averageMonthlyMeals: 0,
                            averageDailyMeals: 0]
        cont.params << newGenerator
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public boolean verifySecurityOfPassword(String password){
        def cont = new ResidueGeneratorController()
        cont.verifySecurityOfPassword(password)
    }
    static public void showGenerator(String name){
        def cont = new ResidueGeneratorController()
        def newGenerator = getGeneratorByName(name)
            cont.show(newGenerator)
    }

    static public void showGeneratorByCnpj(String cnpj){
        def cont = new ResidueGeneratorController()
        def newGenerator = getGeneratorByCnpj(cnpj)
        cont.show(newGenerator)
    }

    static public void editGenerator(String address, def residueGenerator){
        def existingGenerator = getGeneratorByAddress(address)
        if(address != null && existingGenerator == null) {
            def cont = new ResidueGeneratorController()
            cont.params << [name: "Clovis Palace"] << [type: "Restaurante"] << [cnpj: "testecnpj2"] << [addressGenerator: address] << [averageMonthlyMeals: 0] << [averageDailyMeals: 0] << [id: residueGenerator.getId()]
            cont.edit()
            cont.save()
            cont.response.reset()
        }
    }

    static public getAltGenerator(String address){
        def novoGenerator =  [nameGenerator: "Alt",
                              type: "Restaurante",
                              cnpj: "testecnpj1",
                              addressGenerator: address,
                              averageMonthlyMeals: 0,
                              averageDailyMeals: 0];
        return novoGenerator;
    }

    static public void createAltGenerator(String address){
        def cont = new ResidueGeneratorController()
        def novoGenerator = getAltGenerator(address)
        cont.params << novoGenerator
        cont.create()
        cont.save()
        cont.response.reset()

    }

    static public void createIncompleteGenerator(String address){
        def cont = new ResidueGeneratorController()
        cont.params << [nameGenerator: "",
                        type: "Restaurante",
                        cnpj: null,
                        addressGenerator: address,
                        averageMonthlyMeals: null,
                        averageDailyMeals: 0];
        cont.create()
        cont.save()
        cont.response.reset()
    }

    //LIST FEATURES
    static public void createGeneratorWithDailyMeal(String address, int dailymeal){
        def cont = new ResidueGeneratorController()
        def novoGenerator = getGeneratorByAddress("Bubble Street number 7")
        cont.params << novoGenerator
        cont.params << [addressGenerator: address] << [averageDailyMeals: dailymeal]
        cont.create()
        cont.save()
        cont.response.reset()
    }


    static public boolean containResidueGenerator(String address,ResGen){
        def testresidue = ResidueGenerator.getByAddressGenerator(address)
        return ResGen.contains(testresidue)
    }

    static public boolean isSorted(Residuegenerators) {
        //def isSorted = (Residuegenerators.size() < 2 || (1..<Residuegenerators.size()).every { (Residuegenerators[it - 1].averageDailyMeals).compareTo(Residuegenerators[it].averageDailyMeals) > 0})
        def isSorted = ResidueGenerator.findAll().sort{it.averageDailyMeals}
        isSorted = isSorted.reverse()
        return ((isSorted[0].addressGenerator).equals(Residuegenerators[0].addressGenerator) && (isSorted[1].addressGenerator).equals(Residuegenerators[1].addressGenerator))
    }
    ///////


}