package steps

import user.AdminUserController

public class AdminUserTestDataAndOperations {

    static users = {
        [
                adminName = "John Doe",
                adminCpf = "123.456.789-12",
                adminLogin = "admin",
                adminPassword = "abcdef",
                adminEmail = "johndoe@johndoe.com",
                adminPhone = "0000-0000"
        ]
    }

    static public def createUser(String name, String cpf, String login, String password, String email, String phone){
        def controller = new AdminUserController()
        def newAdminUser = [adminName: name,
                            adminCpf: cpf,
                            adminLogin: login,
                            adminPassword: password,
                            adminEmail: email,
                            adminPhone: phone]
        controller.params << newAdminUser
        controller.create()
        controller.save()
        controller.response.reset()
    }

}