package com.test.base;
import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class test_api {

	public static Response res;
	public static final int iHTTPCode200=200;
	
	public static void main(String[] args) {
		
		String sHost="https://stg-api.cowrks.team/profile-service";
		String 	URI="/v2/auth/profile_exist";
		//String sToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1Njg4MDM1MDEsInVzZXJfaWQiOjcyMzIsInJvbGVzIjpbIm1lbWJlcl9hZG1pbiJdLCJzb3VyY2UiOiJjb25uZWN0X3dlYiIsInVzZXJfbmFtZSI6IkFiaGlzaGVrIFNpbmdoIDEyMyIsImFjY291bnRfaWQiOiJXNjZSM0VTIiwiYWNjb3VudF9uYW1lIjoiQXJwaXQgQ29XcmtzIiwiZW1haWwiOiJhYmhpc2hlay5zaW5naEBjb3dya3MuY29tIn0.ZAFMo9vtuydvQ6E7Mxua_Rr4NhNG3-BmGnQ_e752V_w";
		String URL=sHost+URI;
		
	RestAssured.baseURI=URL;
	System.out.println(URL);
//	Response res=RestAssured.given().body("{\"identifier\": \"ravi.kone@cowrks.com\", \"send_activation_link\":false,\"src\":\"connect_mobile\"}").contentType("application/json").post();

	res=RestAssured.given().body("{\n" + 
			"    \"identifier\": \"ravi.kone@cowrks.com\",\n" + 
			"    \"send_activation_link\":false,\n" + 
			"    \"src\":\"connect_mobile\"\n" + 
			"}").contentType("application/json").post();

	//System.out.println(res.asString());
	System.out.println(res.statusCode());
		
	}
	
	public void resLoginStatusCode() {
		assertEquals(res.statusCode(), iHTTPCode200,"Expected code is 200 and actual is "+res.statusCode());
	}
	


}
