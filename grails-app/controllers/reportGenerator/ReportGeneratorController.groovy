package reportGenerator

import org.springframework.dao.DataIntegrityViolationException

class ReportGeneratorController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def index() {
        redirect(action: "list", params: params)
    }
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reportGeneratorInstanceList: ReportGenerator.list(params), reportGeneratorInstanceTotal: ReportGenerator.count()]
    }
    def create() {
        [reportGeneratorInstance: new ReportGenerator(params)]
    }
    def save() {
        def reportGeneratorInstance = new ReportGenerator(params)
        if (!reportGeneratorInstance.save(flush: true)) {
            render(view: "create", model: [reportGeneratorInstance: reportGeneratorInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), reportGeneratorInstance.id])
        redirect(action: "show", id: reportGeneratorInstance.id)
    }
    def show(Long id) {
        def reportGeneratorInstance = ReportGenerator.get(id)
        if (!reportGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), id])
            redirect(action: "list")
            return
        }
        [reportGeneratorInstance: reportGeneratorInstance]
    }
    def edit(Long id) {
        def reportGeneratorInstance = ReportGenerator.get(id)
        if (!reportGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), id])
            redirect(action: "list")
            return
        }
        [reportGeneratorInstance: reportGeneratorInstance]
    }
    def update(Long id, Long version) {
        def reportGeneratorInstance = ReportGenerator.get(id)
        if (!reportGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), id])
            redirect(action: "list")
            return
        }
        if (version != null) {
            if (reportGeneratorInstance.version > version) {
                reportGeneratorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reportGenerator.label', default: 'ReportGenerator')] as Object[],
                          "Another user has updated this ReportGenerator while you were editing")
                render(view: "edit", model: [reportGeneratorInstance: reportGeneratorInstance])
                return
            }
        }
        reportGeneratorInstance.properties = params
        if (!reportGeneratorInstance.save(flush: true)) {
            render(view: "edit", model: [reportGeneratorInstance: reportGeneratorInstance])
            return
        }
        flash.message = message(code: 'default.updated.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), reportGeneratorInstance.id])
        redirect(action: "show", id: reportGeneratorInstance.id)
    }
    def delete(Long id) {
        def reportGeneratorInstance = ReportGenerator.get(id)
        if (!reportGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), id])
            redirect(action: "list")
            return
        }
        try {
            reportGeneratorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reportGenerator.label', default: 'ReportGenerator'), id])
            redirect(action: "show", id: id)
        }
    }
}