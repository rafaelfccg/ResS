package generatorProductionReport

import residueGenerator.HarvestSolicitation
import residueGenerator.ResidueGenerator

/**
 * Created by ess on 16/11/15.
 */
class GeneratorProductionReportController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    static GeneratorProductionReport gen;


    def index() {
        redirect(action: "create", params: params)
    }

    def create() {
        List<String> periodList = ["mes","ano"]
//        def hasManyrelation = HarvestSolicitation.findAllByConfirmationDateGreaterThan(last)
//        params.put("harvestSolicitations",hasManyrelation)
//        params.put("creationDate",data)

        gen  = new GeneratorProductionReport(params)
        [generatorProductionReportInstance: gen, periodList:periodList]
        //redirect(action: "show", id: generatorProductionReportInstance.id)
    }

    def createYearlyReport(int years) {

        def report = new GeneratorProductionReport()
        report.monthsBack = years
        report.type = "ano"

        report.computeData()

        return report

    }
    def save(long id){
        print(params)
        GeneratorProductionReportController.gen = new GeneratorProductionReport(params)
        GeneratorProductionReportController.gen.creationDate = new Date()
        Date data = new Date()
        Date last = data
        last.setMonth(last.getMonth() -5)

        GeneratorProductionReportController.gen.harvestSolicitations =  HarvestSolicitation.findAllByConfirmationDateGreaterThan(last)
        GeneratorProductionReportController.gen.computeData()

        redirect(action: "show", gene:  GeneratorProductionReportController.gen)
    }

    def show(GeneratorProductionReport gene) {

        def generatorProductionReportInstance = GeneratorProductionReportController.gen.monthsBack // GeneratorProductionReport.get(id)
        print( GeneratorProductionReportController.gen.monthsBack)

        if (!generatorProductionReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'generatorProductionReportInstance.label', default: 'GeneratorProductionReport'), id])
            //redirect(action: "list")

            return
        }
        [generatorProductionReportInstance:  GeneratorProductionReportController.gen]

    }
}
