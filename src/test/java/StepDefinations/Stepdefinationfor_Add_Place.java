package StepDefinations;

import io.cucumber.core.resource.ResourceScanner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import Pojo.AddPlace;
import Pojo.Location;
import Resources.Resourcess;
import Resources.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Stepdefinationfor_Add_Place extends Utils{
	
	
	RequestSpecification Payload;
	RequestSpecification Request;
	ResponseSpecification Response;
	
	JsonPath JS;
	Response Output;
	
	@Given("Added the Addplace Payload with {string} {string}")
	public void added_the_addplace_payload_with(String string, String string2) throws IOException
	{
	Resourcess Data=new Resourcess();
    Payload =given().spec(RequestSpec()).body(Data.testdata(string,string2));
	
	}
	
	@When("User hits to the Addplace API Using the Post Http Request")
	public void user_hits_to_the_addplace_api_using_the_post_http_request() {
		
	Response=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
	Output=Payload.when().post("maps/api/place/add/json").then().spec(Response).extract().response();
	}
	
	@Then("Verify Place is Added Successfully to the Maps")
	public void verify_place_is_added_successfully_to_the_maps() 
	{
	   
	assertEquals(Output.getStatusCode(), 200);      
	}
	
	@Then("Verify {string} showing as {string}")
	public void verify_showing_as(String KEY, String Value) 
	{
		   String res=Output.asString();
		    JsonPath JS=new JsonPath(res);
	       assertEquals(JS.getString(KEY), Value);  
	   
	}
}
