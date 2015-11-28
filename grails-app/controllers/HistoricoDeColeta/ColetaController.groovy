package HistoricoDeColeta

import org.springframework.dao.DataIntegrityViolationException

class ColetaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [coletaInstanceList: Coleta.list(params), coletaInstanceTotal: Coleta.count()]
    }

    def create() {
        [coletaInstance: new Coleta(params)]
    }

    def save() {
        Coleta a = new Coleta(params)
        if(Coleta.findByNomeAndData(a.nome,a.data) == null){
        def coletaInstance = new Coleta(params)

        if (!coletaInstance.save(flush: true)) {
            render(view: "create", model: [coletaInstance: coletaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'coleta.label', default: 'Coleta'), coletaInstance.id])
        redirect(action: "show", id: coletaInstance.id)
        }
    }

    def show(Long id) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "list")
            return
        }

        [coletaInstance: coletaInstance]
    }

    def edit(Long id) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "list")
            return
        }

        [coletaInstance: coletaInstance]
    }

    def update(Long id, Long version) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (coletaInstance.version > version) {
                coletaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'coleta.label', default: 'Coleta')] as Object[],
                          "Another user has updated this Coleta while you were editing")
                render(view: "edit", model: [coletaInstance: coletaInstance])
                return
            }
        }

        coletaInstance.properties = params

        if (!coletaInstance.save(flush: true)) {
            render(view: "edit", model: [coletaInstance: coletaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'coleta.label', default: 'Coleta'), coletaInstance.id])
        redirect(action: "show", id: coletaInstance.id)
    }

    def delete(Long id) {
        def coletaInstance = Coleta.get(id)
        if (!coletaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "list")
            return
        }

        try {
            coletaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'coleta.label', default: 'Coleta'), id])
            redirect(action: "show", id: id)
        }
    }
}
