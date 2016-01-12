package user

import user.AdminUser

class AdminUserController {
    static allowedMethods = [save: "POST"]

    def index() {
        def adminUserInstance = new AdminUser(params)
        render(view: "create", model: [adminUserInstance: adminUserInstance])
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [adminUserInstanceList: AdminUser.list(params), adminUserInstanceTotal: AdminUser.count()]
    }

    def create() {
        [adminUserInstance: new AdminUser(params)]
    }

    def save() {
        def adminUserInstance = new AdminUser(params)
        if (!adminUserInstance.save(flush: true)) {
            render(view: "create", model: [adminUserInstance: adminUserInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'adminUser.label', default: 'AdminUser'), adminUserInstance.adminLogin])
        redirect(action: "index")
    }

    def show(Long id) {
        def adminUserInstance = AdminUser.get(login)
        if (!adminUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'adminUser.label', default: 'AdminUser'), adminLogin])
            redirect(action: "list")
            return
        }

        [adminUserInstance: adminUserInstance]
    }

}
