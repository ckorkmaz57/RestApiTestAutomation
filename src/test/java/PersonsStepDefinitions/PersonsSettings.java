package PersonsStepDefinitions;

import Utils.RestAssured;
import Utils.WireMock;
import com.google.gson.Gson;

public class PersonsSettings {

    public Gson gson = new Gson();
    public WireMock wireMock = new WireMock(8081);
    public RestAssured restAssured = new RestAssured("http://localhost:8081");

}
