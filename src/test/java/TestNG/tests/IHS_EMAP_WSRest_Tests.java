package TestNG.tests;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import TestNG.framework.RestAssuredConfiguration;
import TestNG.framework.Utilities;
import TestNG.utils.ExtentReports.ExtentTestManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IHS_EMAP_WSRest_Tests extends RestAssuredConfiguration{
	
	private static String SpeakerId = null;
	private static String ContactId = null;
	
	
	@Test(priority = 1, enabled=false)
	public void IHSM_EMAP_POST_AddNewSpeaker_RestReq_Test_1() throws Exception{
		RequestSpecification reqSpec = new RestAssuredConfiguration().getRequestSpecification();
		reqSpec.pathParam("eventId", "1001");
		//Request body - Test data
		Map<String,String> speakerTData= new HashMap<String,String>();
		speakerTData.put("saluation", "Mr.");
		speakerTData.put("firstName", "Albus");
		speakerTData.put("lastName", "Dumbledore");
		speakerTData.put("companyName", "IHSMarkit");
		speakerTData.put("jobTitle", "SrTestEngineer");
		speakerTData.put("description", "testDescription");
		speakerTData.put("email","testEmail@test.com");
		speakerTData.put("phone", "123-123-1234");
		speakerTData.put("mobile","132-243-2123");
		speakerTData.put("website", "https://www.google.com");
		speakerTData.put("additionalNotes", "testnotes");
		speakerTData.put("address1", "testAddress1");
		speakerTData.put("address2", "testAddress2");
		speakerTData.put("city", "Chicago");
		speakerTData.put("state", "Illinois");
		speakerTData.put("country", "USA");
		speakerTData.put("postalCode", "60563");
		speakerTData.put("email2", "testemail2@test.com");
		speakerTData.put("lastUpdatedBy", "swathin.ratheendren@ihsmarkit.com");
		speakerTData.put("eventId", "1001");
		
		String AddSpeaker_RequestBody = Utilities.getProcessedJSONRequestBody("EMAP_Speakers/AddSpeaker_JSONReqBody.txt", speakerTData);
		Response response = new RestAssuredConfiguration().postRequest(reqSpec, AddSpeaker_RequestBody, IHSM_EndPoints.POST_AddNewSpeaker, HttpStatus.SC_OK);
		
		JsonPath response_JsonPath = response.jsonPath();
		
		Assert.assertEquals(response_JsonPath.getString("firstName"), "Albus");
		Assert.assertEquals(response_JsonPath.getString("lastName"), "Dumbledore");
		SpeakerId= response_JsonPath.getString("id");
	}
	
	@Test(priority = 2, enabled=false)
	public void IHSM_EMAP_POST_AddNewSpeakerContact_RestReq_Test_2() throws Exception{
		RequestSpecification reqSpec = new RestAssuredConfiguration().getRequestSpecification();
		
		//Request body - Test data
		Map<String,String> speakerContactData= new HashMap<String,String>();
		
		//speakerContactData.put("speakerId", SpeakerId);
		speakerContactData.put("speakerId", "700027");
		speakerContactData.put("name", "Security");
		speakerContactData.put("name", "APIContactAdd");
		speakerContactData.put("title", "APITestTitle");
		speakerContactData.put("company", "ihsmarkit");
		speakerContactData.put("phone", "1231231234");
		speakerContactData.put("mobile", "1231231234");
		speakerContactData.put("email", "swathin.ratheendren@ihsmarkit.com");
		speakerContactData.put("additionalInfo", "testInfo");
		
		String AddSpeaker_RequestBody = Utilities.getProcessedJSONRequestBody("EMAP_Speakers/AddSpeakerContact_JSONReqBody.txt", speakerContactData);
		Response response = new RestAssuredConfiguration().postRequest(reqSpec, AddSpeaker_RequestBody, IHSM_EndPoints.POST_AddSpeakerContact, HttpStatus.SC_OK);
		
		JsonPath response_JsonPath = response.jsonPath();
		
		
		Assert.assertEquals(response_JsonPath.getString("name"), "APIContactAdd");
		Assert.assertEquals(response_JsonPath.getString("contactType.name"), "Security");
		ContactId = response_JsonPath.getString("id"); 
	}
	
	
	@Test(priority = 3, enabled=false)
	public void IHSM_EMAP_PUT_EditSpeakerContact_RestReq_Test_3() throws Exception{
		RequestSpecification reqSpec = new RestAssuredConfiguration().getRequestSpecification();
		
		//Request body - Test data
		Map<String,String> speakerContactData= new HashMap<String,String>();
		
		speakerContactData.put("id", ContactId);
		//speakerContactData.put("speakerId", SpeakerId);
		speakerContactData.put("speakerId", "700027");
		speakerContactData.put("name", "EdittedAPIContactAdd");
		speakerContactData.put("contacttype:name", "Media");
		speakerContactData.put("title", "EdittedAPITestTitle");
		speakerContactData.put("company", "Edittedihsmarkit");
		speakerContactData.put("phone", "0000000000");
		speakerContactData.put("mobile", "0000000000");
		speakerContactData.put("email", "swathin.ratheendren@ihsmarkit.com");
		speakerContactData.put("additionalInfo", "Editted_testInfo");
		
		String AddSpeaker_RequestBody = Utilities.getProcessedJSONRequestBody("EMAP_Speakers/UpdateSpeakerContact_JSONReqBody.txt", speakerContactData);
		new RestAssuredConfiguration().putRequest(reqSpec, AddSpeaker_RequestBody, IHSM_EndPoints.PUT_UpdateSpeakerContact, HttpStatus.SC_NO_CONTENT);
	}
	
	
	@Test(priority=4,enabled=false)
	public void IHSM_EMAP_GET_Agenda_Timslot_SessionInfo_RestReq_Test_2(){
		System.out.println("New Trial 29-05-18");
		RequestSpecification reqSpec = new RestAssuredConfiguration().getRequestSpecification();
		reqSpec.queryParam("eventId", "1001");
		reqSpec.queryParam("sessionTypeId", "0");
		reqSpec.queryParam("day", "Monday");
		reqSpec.queryParam("sessionId", "10209");
		Response response = new RestAssuredConfiguration().getRequest(reqSpec, IHSM_EndPoints.GET_Agenda_Timeslot_SessionInfo, HttpStatus.SC_OK);
		//ValidatableResponse validatableResponse =  new RestAssuredConfiguration().getResponse(reqSpec, IHSM_EndPoints.GET_Agenda_Timeslot_SessionInfo, HttpStatus.SC_OK).then();
		
		//Type 1 - Simple (Working) Note: Need to write lines to fetch & validate each node in json or accept as collection object & iteratively validate.
		//ValidatableResponse validatableResponse = response.then().body("title",equalTo("TestNewmeSlot"));

		List<String> timeSlotTitle = response.jsonPath().get("title");
		System.out.println("TimeSlotTitle: "+timeSlotTitle.get(0));
		Assert.assertEquals(timeSlotTitle.get(0), "10 test");
		
		JsonPath pathEval = response.jsonPath();
		String SessionTitle = pathEval.getString("sessions[0].title[0]");
 		System.out.println("SessionTitle: "+SessionTitle);
 		Assert.assertEquals(SessionTitle, "A Future Energy Leaders conversation: Attracting and retaining great talent");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test -- FIll info msg pending");
		
		//List SpeakerName = pathEval.get("sessions.speakers[0].name[0]");
		String SpeakerName = pathEval.getString("sessions[0].speakers[0].name[0]");
		String SpeakerName2 = pathEval.getString("sessions[0].speakers[0].name[-1]");
		
		System.out.println("Speaker Name: "+SpeakerName.toString());
		System.out.println("Speaker Name2: "+SpeakerName2);
		String FullBody = response.getBody().asString();
		System.out.println(FullBody);
	} 
	
	
}
