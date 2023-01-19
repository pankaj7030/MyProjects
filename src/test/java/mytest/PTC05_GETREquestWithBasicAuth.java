package mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PTC05_GETREquestWithBasicAuth {
	
	@Test
	public void getRquestWithBasicAuth() {
		
		//Specify base URL
		RestAssured.baseURI="http://httpbin.org/basic-auth/foo";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
		authScheme.setUserName("foo");
		authScheme.setPassword("bar");
		
		RestAssured.authentication=authScheme;
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/bar");
		
		//Print response in console
		String responseBody=response.body().asString();
		System.out.println("Response body:="+responseBody);
		
		//validate status code
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//get node
		Headers header = response.headers();
		System.out.println(header);
	
	
	}

}
