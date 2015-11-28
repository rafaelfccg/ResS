package user

class AdminUser {
    String adminName
    String adminCpf
    String adminLogin
    String adminPassword
    String adminEmail
    String adminPhone

    static constraints = {
        adminName nullable:false, blank:false
        adminCpf nullable:false, blank:false, unique:true
        adminLogin nullable:false, blank:false, unique:true
        adminPassword nullable:false, blank:false, minSize:6
        adminEmail nullable:false, blank:false
        adminPhone nullable:false, blank:false
    }

}