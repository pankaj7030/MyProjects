package mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PTC01_GETRequest {

	
	
	
	@Test
	public void getRequest() {
		
		//Specify base URI
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee";
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		//Response object
		Response response=httpRequest.request(Method.GET,"/1");
		//Print response in console
		String RequestBody=response.getBody().asString();//{"status":"success","data":{"id":1,"employee_name":"Tiger Nixon","employee_salary":320800,"employee_age":61,"profile_image":""},"message":"Successfully! Record has been fetched."}
        System.out.println("Response Body:-"+RequestBody);
        
        //Validate Status code
        int statusCode=response.getStatusCode();
        System.out.println("status code:-"+statusCode);
        Assert.assertEquals(statusCode, 200);
        
        //validate status line
        String statusLine=response.getStatusLine();
        System.out.println("status Line:-"+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		
	}
}
