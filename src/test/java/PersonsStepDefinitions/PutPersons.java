package PersonsStepDefinitions;

import Models.PersonsModel.PersonsRequestModel;
import Models.PersonsModel.PersonsResponseModel;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class PutPersons {

    PersonsSettings personsSettings;

    public PutPersons(PersonsSettings personsSettings){
        this.personsSettings=personsSettings;
    }

    @Given("^PUT \"(.*)\" endpoint returns (.*) and body list$")
    public void putEndpointReturns(String url,int statusCode, List<PersonsResponseModel> personsList) {

        personsSettings.wireMock.stubPutResponse(url,personsSettings.gson.toJson(personsList),statusCode);

    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {

        return cell;

    }

    @When("^PUT \"(.*)\" endpoint is called$")
    public void putEndpointIsCalled(String endpoint,List<PersonsRequestModel> personsList) {

        personsSettings.restAssured
                .setRequestBody(personsSettings.gson.toJson(personsList.get(0)))
                .setEndpoint(endpoint)
                .sendPutRequest();

    }

}
