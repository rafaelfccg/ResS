package residueCollector

/**
 * Created by ess on 21/10/15.
 */


import org.springframework.dao.DataIntegrityViolationException

class ResidueCollectorController {

    static allowedMethos = [save: "POST", update: "POST", delete: "POST"]

    def index (){
        redirect(action: "list", params: params)
    }


    def create(){
        [residueCollectorInstance: new ResidueCollector(params)]
    }

    def save(){

        def residueCollectorInstance = new ResidueCollector(params)

        if (!residueCollectorInstance.save(flush: true)){
            render(view: "create", model: [residueCollectorInstance: residueCollectorInstance])
            return
        }

        residueGeneratorInstance.errors
        flash.message = message(code: 'default.created.message', args: [message(code: 'residueCollector.label', default: 'ResidueCollector'), residueCollectorInstance.id])
    }

}
