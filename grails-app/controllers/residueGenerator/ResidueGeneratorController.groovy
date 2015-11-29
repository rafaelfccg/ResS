package residueGenerator

import org.springframework.dao.DataIntegrityViolationException

class ResidueGeneratorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def search(Integer max){
        params.max = Math.min(max ?: 10, 100)
        [residueGeneratorInstanceList: ResidueGenerator.list(params), residueGeneratorInstanceTotal: ResidueGenerator.count()]
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [residueGeneratorInstanceList: ResidueGenerator.list(params), residueGeneratorInstanceTotal: ResidueGenerator.count()]
    }

    def create() {

        [residueGeneratorInstance: new ResidueGenerator(params)]
    }
    //#if ($RegisterAResidueGenerator)
    def verifySecurityOfPassword(String password){

        if(password ==null) return false

        return password.length() >=8

    }
    //#end
    def save() {

        def residueGeneratorInstance = new ResidueGenerator(params)

        if (!residueGeneratorInstance.save(flush: true)) {
            render(view: "create", model: [residueGeneratorInstance: residueGeneratorInstance])
            return
        }
        residueGeneratorInstance.errors
        flash.message = message(code: 'default.created.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), residueGeneratorInstance.id])
        redirect(action: "show", id: residueGeneratorInstance.id)

    }

    def show(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
            redirect(action: "list")
            return
        }

        [residueGeneratorInstance: residueGeneratorInstance]
    }

    def edit(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
            redirect(action: "list")
            return
        }

        [residueGeneratorInstance: residueGeneratorInstance]
    }

    def update(Long id, Long version) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (residueGeneratorInstance.version > version) {
                residueGeneratorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'residueGenerator.label', default: 'ResidueGenerator')] as Object[],
                        "Another user has updated this ResidueGenerator while you were editing")
                render(view: "edit", model: [residueGeneratorInstance: residueGeneratorInstance])
                return
            }
        }

        residueGeneratorInstance.properties = params

        if (!residueGeneratorInstance.save(flush: true)) {
            render(view: "edit", model: [residueGeneratorInstance: residueGeneratorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), residueGeneratorInstance.id])
        redirect(action: "show", id: residueGeneratorInstance.id)
    }

    def delete(Long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if (!residueGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
            redirect(action: "list")
            return
        }

        try {
            residueGeneratorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'residueGenerator.label', default: 'ResidueGenerator'), id])
            redirect(action: "show", id: id)
        }
    }
}