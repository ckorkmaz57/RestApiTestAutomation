package PersonsStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonStepDefinitions {

    PersonsSettings personsSettings;

    public CommonStepDefinitions(PersonsSettings personsSettings){
        this.personsSettings=personsSettings;
    }

    @Before()
    public void beforeTest() {

        personsSettings.wireMock.startWireMock();

    }

    @After()
    public void afterTest() {

        personsSettings.wireMock.resetWireMock();

    }

}
