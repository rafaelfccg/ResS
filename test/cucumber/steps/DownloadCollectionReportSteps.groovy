package steps

import pages.ColetaListPage
import pages.CollectReportPage

import static cucumber.api.groovy.EN.*

import steps.CreateColetaTestDataAndOperations
import steps.NoColetasException

// CONTROLLER STEPS

//Scenario:File generation

Given (~'^that there were collections on at least one residue generator on month "([^"]*)"$'){
    String month ->
        coletas = CreateColetaTestDataAndOperations.findColetaByDate(month)
        assert coletas != null
}

And (~'^I have created a report$'){
    ->
    try {
      def calc = CreateColetaTestDataAndOperations.calcVolume("11")
      assert calc != null
    }
    catch(NoColetasException e) {
      assert false
    }
}

When (~'^the system receives a request to create an CSV file of the report$'){
     ->try {
      def calc = CreateColetaTestDataAndOperations.genCSV("11")
    }
    catch(NoColetasException e) {
      assert false
    }
       
}


Then (~'^a CSV file is sent to the client$'){
    ->
   	
}


//Scenario:Error in file generation
Given (~'^that there were no collections made on at least one residue generator on month "([^"]*)"$'){  
  String month -> coletas = CreateColetaTestDataAndOperations.findColetaByDate(month)
        assert coletas == null
    
}

And (~'^I there are no reports in the database$'){
    -> try {
      def calc = CreateColetaTestDataAndOperations.calcVolume("12")
      
    }
    catch(NoColetasException e) {
      assert true
    }
}

When (~'^the system receives a request to create an CSV file of the current report$'){
     ->
        
}


Then (~'^a error is given$'){
    -> try {
      def calc = CreateColetaTestDataAndOperations.genCSV("11")
    }
    catch(NoColetasException e) {
      assert true
    }
   	
}

//GUI

//Scenario:Download a report

Given (~'^I am at the Relatorios Page$'){ -> to ColetaListPage
     page.selectTodayDate()
     page.submit()
    to CollectReportPage
}

When (~'^I select the "([^"]*)" option$'){ 
    String option -> at CollectReportPage
    if (option == "CSV") {
      page.getCSV()
    }
        
}

Then (~'^I should get the CSV file of the report$'){
    -> 

}
