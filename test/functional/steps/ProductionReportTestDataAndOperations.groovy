package steps
import generatorProductionReport.GeneratorProductionReport
import residueGenerator.HarvestSolicitation

/**
 * Created by ess on 11/01/16.
 */
class ProductionReportTestDataAndOperations {
    static report = new GeneratorProductionReport()

    public static GeneratorProductionReport getReport(){
        return report
    }

    public static void setReport(int month){
        report.monthsBack = month
        report.creationDate = new Date()
        Date data = new Date()
        Date last = data
        last.setMonth(last.getMonth() -5)
        report.harvestSolicitations =  HarvestSolicitation.findAllByConfirmationDateGreaterThan(last)
        report.computeData()
    }

}
