package PersonsStepDefinitions;

import Models.PersonsApiModel.Persons;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class GetPersonsStepDefinitions {

    @DataTableType
    public Persons createPersons(Map<String,String> tableItems){

        return Persons.createPersons(tableItems);

    }

    @Given("GET {string} endpoint returns list")
    public void getEndpointReturnsList(List<Persons> personsList,String endpoint){

    }

}
