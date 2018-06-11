package TestNG.framework;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfiguration{

	@BeforeClass(alwaysRun=true)
	public void Configure(){
		RestAssured.baseURI="http://dev.emap.ihsmarkit.info.corp";
	}
	
	public RequestSpecification getRequestSpecification() {
		return RestAssured.given().header("Authorization", "Basic c3dhdGhpbi5yYXRoZWVuZHJlbkBpaHNtYXJraXQuY29tOlJDeWJlckcwNDg4JA==").auth().basic("swathin.ratheendren@ihsmarkit.com", "RCyberG0488$").contentType(ContentType.JSON);
	}
	
	public Response getRequest(RequestSpecification requestSpecification, String endPoint, int status) {
		Response response = requestSpecification.get(endPoint);
		Assert.assertEquals(response.getStatusCode(),status);
		response.then().log().all();
		return response;
	}
	
	public Response postRequest(RequestSpecification requestSpecification, String RequestBody,String endPoint, int status) {
		Response response = requestSpecification.body(RequestBody).post(endPoint);
		Assert.assertEquals(response.getStatusCode(),status);
		response.then().log().all();
		return response;
	}
	
	public Response putRequest(RequestSpecification requestSpecification, String RequestBody,String endPoint, int status) {
		Response response = requestSpecification.body(RequestBody).put(endPoint);
		Assert.assertEquals(response.getStatusCode(),status);
		response.then().log().all();
		return response;
	}
	
	public Response deleteRequest(RequestSpecification requestSpecification, String RequestBody,String endPoint, int status) {
		Response response = requestSpecification.body(RequestBody).delete(endPoint);
		Assert.assertEquals(response.getStatusCode(),status);
		response.then().log().all();
		return response;
	}
	
}
