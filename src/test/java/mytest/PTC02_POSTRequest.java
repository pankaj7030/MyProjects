package mytest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataDrivern_Testing.UtilityClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PTC02_POSTRequest {
	
	@Test(dataProvider="getdata")
	public void postRequest(String ama,String kak) {
		
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("name",ama);
		requestParams.put("job",kak);
		
		//Specify the content type/format as json,text etc
		
		httpRequest.header("content-type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response object
		Response response=httpRequest.request(Method.POST,"/users");
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body:-"+ResponseBody);
		
		//validate status code
		int responseCode=response.getStatusCode();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode,201);
		
		//validate status line 
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 201 Created");
		
		//validate success code
		String sessionID=response.getSessionId();
		System.out.println("session ID:-"+sessionID);
		
		//
		String successCode=response.jsonPath().get("job");
		System.out.println("success code:-"+successCode);
		Assert.assertEquals(successCode,kak);
		
	}
	
	@DataProvider(name="getdata")
	public String[] [] getData_Dataprovider() {
		String [][]data= {{"kaka","jattu"},{"mama","kadu"},{"msti","partner"}};
		
		return data;
	}

}
