package mytest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PTC04_getJSONDATA {
	
	@Test
	public void get_JSONData() {
		
		//specify base url
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
	    //Response object
		Response response=httpRequest.request(Method.GET,"/2");
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		
		//finding the value of node by using jsonPath 
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("name"));
		System.out.println(jsonpath.get("photoUrls"));
		System.out.println(jsonpath.get("tags"));
		System.out.println(jsonpath.get("status"));
	}

}
