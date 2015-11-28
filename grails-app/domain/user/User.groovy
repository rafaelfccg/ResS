package user

/**
 * Created by Daniel on 05/09/2015.
 */
class User {

    int id
    String name
    String address
    String login
    String password

    static constraints = {
        id nullable:false, blank:false, unique: true
        name nullable: false, blank: false
        address nullable: false, blank: false
        login nullable: false, blank: false, unique: true
        password nullable:false, blank: false, minSize: 6
    }

}
