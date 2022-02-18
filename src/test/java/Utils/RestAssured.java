package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RestAssured {

    RequestSpecification request;
    Response response;
    ValidatableResponse json;
    private JsonPath jpath;
    String url;

    public RestAssured(String url) {

        this.url = url;
        this.request = given().header("Content-Type", "application/json").baseUri(this.url);

    }

    public RestAssured setHeaderKeyValue(String Key, String Val) {

        request.header(Key, Val);
        return this;

    }

    public RestAssured setRequestBody(String Body) {

        request.body(Body);
        return this;

    }

    public RestAssured sendPostRequest() {

        this.response = request.when().post();
        return this;

    }

    public void sendGetRequest() {

        this.response = request.when().get();

    }

    public void sendPutRequest() {

        this.response = request.when().put();

    }

    public Response getResponseBody() {

        return response;

    }

    public int getResponseStatusCode() {

        return response.statusCode();

    }

    public String getResponseSingleField(String path) {

        jpath = response.jsonPath();
        return jpath.get(path) ;

    }

    public ArrayList<String> getResponseAllFields() {

        jpath = response.jsonPath();
        return jpath.get() ;

    }

    public RestAssured setEndpoint(String endpoint) {

        request.baseUri(this.url + endpoint);
        return this;

    }

    public RestAssured setParameter(String key, String val) {

        request.param(key, val);
        return this;

    }

}