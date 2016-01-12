package steps

import user.AdminUser
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

    static public def createUser(String login){
        def controller = new AdminUserController()
        def newAdminUser = [adminName: "Name",
                            adminCpf: "Cpf",
                            adminLogin: login,
                            adminPassword: "Password",
                            adminEmail: "email",
                            adminPhone: "phone"]
        controller.params << newAdminUser
        controller.create()
        controller.save()
        controller.response.reset()
    }
    static public def createUserByEmail(String email){
        def controller = new AdminUserController()
        def newAdminUser = [adminName: "Name",
                            adminCpf: "Cpf",
                            adminLogin: "admin",
                            adminPassword: "Password",
                            adminEmail: email,
                            adminPhone: "phone"]
        controller.params << newAdminUser
        controller.create()
        controller.save()
        controller.response.reset()
    }

    static public void deleteUser(AdminUser user){
        def cont = new AdminUserController()
        cont.params << [id: user.id]
        cont.delete()
        cont.response.reset()
    }

    static public void editUser(String email, def adminUser){
        def oldUser = AdminUser.findByAdminEmail(email)
        def newAdminUser = [adminName:adminUser.getAdminName(),
                            adminCpf: adminUser.getAdminCpf(),
                            adminLogin: adminUser.getAdminLogin(),
                            adminPassword: adminUser.getAdminPassword(),
                            adminEmail: email,
                            adminPhone: adminUser.getAdminPhone()]
        if(email != null && oldUser != null) {
            def cont = new AdminUserController()
            cont.params << newAdminUser
            cont.edit()
            cont.response.reset()
        }
    }

}