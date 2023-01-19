package mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PTC03_GETHeaders {
	@Test
	void getPetDetails() {
		
		//Specify base URI
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/10");
		
		//Print response in console window 
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//validating the data in the body
		Assert.assertEquals(responseBody.contains("doggie"), true); 
		
		//get header name and values
		Headers allheaders=response.headers();
		
		for(Header header:allheaders) {
			System.out.println(header.getName()+" :-  "+header.getValue());
			
			
		}
		
		
		//Status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status code: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line validation
		String statusLine=response.getStatusLine();
		System.out.println("Status line is: "+ statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
}


