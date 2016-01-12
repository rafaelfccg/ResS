
package steps

/**
 * Created by Franclin Cabral on 05/10/15.
 */

/*
//Controller

/*

Given (~'^That there is no collector with the email "([^"]*)"$'){ String email ->
    collector = ResidueCollector.findByEmailCollector(email)
    assert collector == null
}


And(~'^There is no registered CNPJ "([^"]*)"$'){String cnpj ->
    collector = ResidueCollector.findByCnpjCollector(cnpj)
    assert collector == null
}

When (~'^I register the new collector with email "([^"]*)"$'){ String email ->
    collectorEmail = email
    assert collector.email == collectorEmail

}

And (~'^with CNPJ "([^"]*)"$'){String cnpj ->
    collectorCnpj = cnpj
    assert collector.cnpj == collectorCnpj
}

Then (~'^the collector with email "([^"]*)"$'){ String email ->
    CollectorTestDataAndOperations.createCollector(email)
    assert ResidueCollector.findByEmailCollector(email) != nul
}

And (~'^CNPJ "([^"]*)" is created in the system$'){ String cnpj ->
    CollectorTestDataAndOperations.createCollector(cnpj)
    assert ResidueCollector.findByCnpjCollector(cnpj) != null
}


*/

//Gui
/*

Given (~'^That I am in the form page of register new collector$'){
    to CollectorCreatePage
    at CollectorCreatePage
}

And (~'^I fill the fields with new Collector information$'){
    page.fillCollectorDetails(collector)
}

And (~'^there is no Previous COllector with email "([^"]*)"$'){ String email ->
    collector = ResidueCollector.findByEmailCollector(email)
    assert collector == null
}

And (~'^no CNPJ "([^"]*)" I filled in the form$'){ String cnpj ->
    collector = ResidueCollector.findByEmailCollector(cnpj)
    assert collector == null
}

When (~'^I press the button "([^"]*)"$'){ String buttonName ->
    page.selectCreateCollector()

}


Then (~'^The system show me a success message "([^"]*)" $'){String msg ->
    assert withConfirm(true) { $("input", name: "showConfirm").click()} == "The collector has been registered with success!"

}
*/
