package PersonsStepDefinitions;

import Models.PersonsApiModel.Persons;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GetPersons {

    PersonsSettings personsSettings;

    public GetPersons(PersonsSettings personsSettings){
        this.personsSettings=personsSettings;
    }

    @DataTableType
    public Persons createPersons(Map<String,String> tableItems){

        return Persons.createPersons(tableItems);

    }

    @Given("^GET \"(.*)\" endpoint returns (.*) and body list$")
    public void getEndpointReturnsList(String url,int status,List<Persons> personsList){

        personsSettings.wireMock.stubGetResponse(url,personsSettings.gson.toJson(personsList),status);

    }

    @When("^GET \"(.*)\" endpoint is called")
    @When("^GET \"(.*)\" endpoint is called without parameters$")
    public void getEndpointIsCalledWithoutParameters(String url) {

        personsSettings.restAssured
                .setURL("http://localhost:8081" + url)
                .sendGetRequest();

    }

    @Then("^HTTP status code should be (.*)$")
    public void httpStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode,personsSettings.restAssured.getResponseStatusCode());

    }

    @And("Persons should be")
    public void personsShouldBe(List<Persons> personsList) {

        JsonPath personListJson = personsSettings.restAssured.getResponseBody().jsonPath();

        Assert.assertEquals(personsSettings.gson.toJsonTree(personListJson.get()),personsSettings.gson.toJsonTree(personsList));

    }
}
