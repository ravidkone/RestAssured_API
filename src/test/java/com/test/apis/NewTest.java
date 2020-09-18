package com.test.apis;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {
	
	  String sHost="https://stg-api.cowrks.team/profile-service";

  @Test
  public void userExists() {
		String 	userExists="/v2/auth/profile_exist";
		//String sToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1Njg4MDM1MDEsInVzZXJfaWQiOjcyMzIsInJvbGVzIjpbIm1lbWJlcl9hZG1pbiJdLCJzb3VyY2UiOiJjb25uZWN0X3dlYiIsInVzZXJfbmFtZSI6IkFiaGlzaGVrIFNpbmdoIDEyMyIsImFjY291bnRfaWQiOiJXNjZSM0VTIiwiYWNjb3VudF9uYW1lIjoiQXJwaXQgQ29XcmtzIiwiZW1haWwiOiJhYmhpc2hlay5zaW5naEBjb3dya3MuY29tIn0.ZAFMo9vtuydvQ6E7Mxua_Rr4NhNG3-BmGnQ_e752V_w";
		String URL=sHost+userExists;
		
	RestAssured.baseURI=URL;

	Response res=RestAssured.given().body("{\"identifier\": \"ravi.kone@cowrks.com\", \"send_activation_link\":false,\"src\":\"connect_mobile\"}").contentType("application/json").post();

	System.out.println(res.statusCode());
	System.out.println(res.asString());
	System.out.println(res.jsonPath().getString("user_exist"));
	
	res.prettyPrint();

  }
  
  @Test
  public void signUp() {
		  String sPayloadSignUpNew="{\n" + 
				"	\"src\": \"launchpad_web\",\n" + 
				"	\"email\": \"REPLACE_EMAIL\",\n" + 
				"	\"phone_number\": \"9686250595\",\n" + 
				"	\"country_code\": \"+91\",\n" + 
				"	\"name\": \"Test Ravi\",\n" + 
				"	\"password\": \"test1234\",\n" + 
				"	\"account\": \"EE2SCE3\",\n" + 
				"	\"member_type\": 1\n" + 
				"}";
	  
	  
	String  sEmailID = "ravi.kone"+RandomStringUtils.randomNumeric(4)+"@cowrks.com";
		System.out.println("New Email Address is:"+sEmailID);
		String signUp="/v2/auth/sign_up";
		RestAssured.baseURI=sHost+signUp;
		Response res=RestAssured.given().body(sPayloadSignUpNew.replaceAll("REPLACE_EMAIL", sEmailID)).post();
	System.out.println(res.getStatusCode());
	System.out.println(res.jsonPath().getString("data.id"));
	//	res.prettyPrint();
  }
}
