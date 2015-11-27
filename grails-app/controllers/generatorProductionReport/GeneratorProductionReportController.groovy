package generatorProductionReport

import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

/**
 * Created by ess on 16/11/15.
 */
class GeneratorProductionReportController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    GeneratorProductionReport gen;


    def index() {
        redirect(action: "create", params: params)
    }

    def create() {
        List<String> periodList = ["mes","ano"]
//        def hasManyrelation = HarvestSolicitation.findAllByConfirmationDateGreaterThan(last)
//        params.put("harvestSolicitations",hasManyrelation)
//        params.put("creationDate",data)

        def generatorProductionReportInstance = new GeneratorProductionReport(params)
        [generatorProductionReportInstance: generatorProductionReportInstance, periodList:periodList]
        //redirect(action: "show", id: generatorProductionReportInstance.id)
    }

    def createMonthlyReport(int months){
        return new GeneratorProductionReport()
    }

    def save(long id){
        print(params)
        def generatorProductionReportInstance = new GeneratorProductionReport(params)
        generatorProductionReportInstance.creationDate = new Date()
        Date data = new Date()
        Date last = data
        last.setMonth(last.getMonth() -5)
        generatorProductionReportInstance.harvestSolicitations =  HarvestSolicitation.findAllByConfirmationDateGreaterThan(last)
        generatorProductionReportInstance.computeData()

        //if(!generatorProductionReportInstance.save(flush: true, failOnError: true)){
        //    List<String> periodList = ["mes","ano"]
        //    render(view: "create", model: [generatorProductionReportInstance: generatorProductionReportInstance, periodList:periodList])
        //    return
        //}
        if (!generatorProductionReportInstance) {
            print("TA NULO? LOL")

        }
        redirect(action: "show", gene: generatorProductionReportInstance)
    }

    def show(GeneratorProductionReport gene) {
        def generatorProductionReportInstance = gene // GeneratorProductionReport.get(id)

        if (!generatorProductionReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'generatorProductionReportInstance.label', default: 'GeneratorProductionReport'), id])
            //redirect(action: "list")

            return
        }
        [generatorProductionReportInstance: generatorProductionReportInstance]

    }
}
