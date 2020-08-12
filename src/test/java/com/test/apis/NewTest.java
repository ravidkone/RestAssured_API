package com.test.apis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {
	

  @Test
  public void f() {
	  String sHost="https://stg-api.cowrks.team/profile-service";
		String 	URI="/v2/auth/profile_exist";
		//String sToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1Njg4MDM1MDEsInVzZXJfaWQiOjcyMzIsInJvbGVzIjpbIm1lbWJlcl9hZG1pbiJdLCJzb3VyY2UiOiJjb25uZWN0X3dlYiIsInVzZXJfbmFtZSI6IkFiaGlzaGVrIFNpbmdoIDEyMyIsImFjY291bnRfaWQiOiJXNjZSM0VTIiwiYWNjb3VudF9uYW1lIjoiQXJwaXQgQ29XcmtzIiwiZW1haWwiOiJhYmhpc2hlay5zaW5naEBjb3dya3MuY29tIn0.ZAFMo9vtuydvQ6E7Mxua_Rr4NhNG3-BmGnQ_e752V_w";
		String URL=sHost+URI;
		
	RestAssured.basePath=URL;

	Response res=RestAssured.given().body("{\"identifier\": \"ravi.kone@cowrks.com\", \"send_activation_link\":false,\"src\":\"connect_mobile\"}").contentType("application/json").post();
	System.out.println(res.toString());
	System.out.println(res.statusCode());
	System.out.println(res.asString());

  }
}
