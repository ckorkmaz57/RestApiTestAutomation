package Utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssured {

    RequestSpecification request;
    Response response;
    ValidatableResponse json;

    public RestAssured(String URL) {

        this.request = given().header("Content-Type", "application/json").baseUri(URL);

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

    public Response getResponseBody() {

        return response;

    }

    public int getResponseStatusCode() {

        return response.statusCode();

    }

    public RestAssured setURL(String URL) {

        request.baseUri(URL);
        return this;
    }

    public RestAssured setParameter(String key, String val) {

        request.param(key, val);
        return this;

    }

}