import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GETRequest {

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
