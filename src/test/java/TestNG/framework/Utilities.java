package TestNG.framework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utilities{

	@SuppressWarnings("unchecked")
	public static String getProcessedJSONRequestBody(String FilePath,Map<String,String> JSONData) throws IOException, ParseException {

		String innerJSONObjects=null;
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/test/java/TestNG/WS_RestTestFiles/JSON_TestData/"+FilePath));
		JSONObject jsonObject = (JSONObject) obj;
		String JSONObjects = jsonObject.toJSONString();
		
		System.out.println("Original JSON Request Body: "+JSONObjects);
		
		Set<String> NameSet = JSONData.keySet();
		System.out.println("initial size: "+NameSet.size()+" "+NameSet.toString());

		for (String key:NameSet){
			if(key.contains("{")) {
				String[] childPath = key.split("\\{");
				JSONObject innerJSONObject = (JSONObject) jsonObject.get(childPath[0]);
				innerJSONObject.put(childPath[1], JSONData.get(childPath[0]+"{"+childPath[1]));
				jsonObject.put(childPath[0],innerJSONObject);
				JSONObjects = jsonObject.toJSONString();
			}else {
			JSONObjects = JSONObjects.replaceFirst("\""+key+"\":\""+key+"\"", "\""+key+"\":\""+JSONData.get(key)+"\"");
			JSONObjects = JSONObjects.replaceFirst("\""+key+"\":0", "\""+key+"\":"+JSONData.get(key));
			}
		}
		System.out.println("Updated JSON Request Body: "+JSONObjects);
		return JSONObjects;
	}

	
	
	public static void main(String[] args)throws Exception{
		/*Map<String,String> hm= new HashMap<String,String>();
		hm.put("saluation", "Mr.");
		hm.put("firstName", "Albus");
		hm.put("lastName", "Dumbledore");
		hm.put("companyName", "IHSMarkit");
		hm.put("jobTitle", "SrTestEngineer");
		hm.put("description", "testDescription");
		hm.put("email","testEmail@test.com");
		hm.put("phone", "123-123-1234");
		hm.put("mobile","132-243-2123");
		hm.put("website", "https://www.google.com");
		hm.put("additionalNotes", "testnotes");
		hm.put("address1", "testAddress1");
		hm.put("address2", "testAddress2");
		hm.put("city", "Chicago");
		hm.put("state", "Illinois");
		hm.put("country", "USA");
		hm.put("postalCode", "60563");
		hm.put("email2", "testemail2@test.com");
		hm.put("lastUpdatedBy", "swathin.ratheendren@ihsmarkit.com");
		hm.put("eventId", "1001");
		getProcessedJSONRequestBody("EMAP_Speakers/AddSpeaker_JSONReqBody.txt", hm);
		*/
		
		//Request body - Test data
		Map<String,String> speakerContactData= new HashMap<String,String>();
				
				speakerContactData.put("id", "123");
				//speakerContactData.put("speakerId", SpeakerId);
				speakerContactData.put("speakerId", "700027");
				speakerContactData.put("contactType{name", "Media");
				speakerContactData.put("name", "EdittedAPIContactAdd");
				speakerContactData.put("title", "EdittedAPITestTitle");
				speakerContactData.put("company", "Edittedihsmarkit");
				speakerContactData.put("phone", "0000000000");
				speakerContactData.put("mobile", "0000000000");
				speakerContactData.put("email", "swathin.ratheendren@ihsmarkit.com");
				speakerContactData.put("additionalInfo", "Editted_testInfo");
		
				getProcessedJSONRequestBody("EMAP_Speakers/UpdateSpeakerContact_JSONReqBody.txt", speakerContactData);
	}

}
