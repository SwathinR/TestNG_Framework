package TestNG.tests;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import TestNG.JSONSchemas.TimeSlotSessionInfo.Session;
import TestNG.JSONSchemas.TimeSlotSessionInfo.Speaker;
import TestNG.JSONSchemas.TimeSlotSessionInfo.TimeSlotSessionInfo;
import TestNG.framework.RestAssuredConfiguration;
import TestNG.utils.ExtentReports.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class IHS_EMAP_WSRest_Tests extends RestAssuredConfiguration{

	@Test
	public void Test_IHSM_RestRequests_1() {
		/*Response response = RestAssured.
				given()
				.header("Authorization", "Basic c3dhdGhpbi5yYXRoZWVuZHJlbkBpaHNtYXJraXQuY29tOlJDeWJlckcwNDg4JA==")
				.auth().basic("swathin.ratheendren@ihsmarkit.com", "RCyberG0488$")
				.when().get("http://dev.emap.ihsmarkit.info.corp/api/timeslots/sessions?eventId=1003&sessionTypeId=0&day=Monday&sessionId=10597");
		System.out.println(response.then().log().body());*/
		System.out.println("New Trial");
		RequestSpecification reqSpec = new RestAssuredConfiguration().getRequestSpecification();
		reqSpec.queryParam("eventId", "1003");
		reqSpec.queryParam("sessionTypeId", "0");
		reqSpec.queryParam("day", "Monday");
		reqSpec.queryParam("sessionId", "10597");
		Response response = new RestAssuredConfiguration().getResponse(reqSpec, IHSM_EndPoints.GET_Agenda_Timeslot_SessionInfo, HttpStatus.SC_OK);
		
		
		//TODO Find out if there is another way to validate JSON response. 
		
		//Type 1
		ValidatableResponse x = response.then().body("title",equalTo("TestNewTimeSlot"));
		System.out.println(x.toString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test -- FIll info msg pending");
		
		//Type 2
		TimeSlotSessionInfo timeSlotSessionInfo = response.as(TimeSlotSessionInfo.class, ObjectMapperType.GSON);
		Session sessionInfo = response.as(Session.class, ObjectMapperType.GSON);
		
		SoftAssert softAssert = new SoftAssert();
		List<Session> sessions = timeSlotSessionInfo.getSessions();
		List<Speaker> speakerInfo = sessionInfo.getSpeakers();
		
		for(Session session: sessions) {
			softAssert.assertTrue(session.getTitle().equals("A New Energy System"),"Sessions don't match");
		}
		String[] SpeakersNames = {"Oscar Abbink","Wendell Brase"};
		int i = 0;
		for(Speaker speaker: speakerInfo) {
			softAssert.assertTrue(speaker.getName().equals(SpeakersNames[i]),"Speakers don't match");
			i++;
		}
	} 
}
