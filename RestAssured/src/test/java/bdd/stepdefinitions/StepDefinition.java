package bdd.stepdefinitions;

import bdd.resources.APIResources;
import bdd.resources.TestDataBuild;
import bdd.resources.Utils;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;
public class StepDefinition extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();
    @Given("Add Place Payload with \"<name>\" \"<language>\" \"<address\">")
    public void add_place_payload_with_something_something_something(String name, String language, String address) throws IOException {
        res=given().spec(requestSpecification())
                .body(testDataBuild.addPlacePayload(name,language,address));

        throw new io.cucumber.java.PendingException();
    }

    @When("User calls {string} with POST HTTP Request")
    public void user_calls_with_post_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        //System.out.println(resourceAPI.getResource());
        resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST")){
            response =res.when().post(resourceAPI.getResource());
        }else if(method.equalsIgnoreCase("GET")){
            response =res.when().get(resourceAPI.getResource());
        }
    }

    @Then("The API call is success with the status code {int}")
    public void the_api_call_is_success_with_the_status_code(Integer int1) {
        assertEquals(response.getStatusCode(),200);

    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        assertEquals(getJsonPath(response, keyValue), expectedValue);
    }

    @Then("^verify place_Id created maps to {string} using {string}")
    public void verify_placeid_created_maps_to_something_using_something(String expectedName, String resource) throws IOException {
        String placeID = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", placeID);
        user_calls_with_post_http_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        assertEquals(actualName, expectedName);
    }

}
