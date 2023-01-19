import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POSTRequest {

	
	@Test
	void postRequest_createData() {
		
		//Specify Base URI
		RestAssured.baseURI="https://petstore.swagger.io/v2/store";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		
		JSONObject requestParams =new JSONObject();
		requestParams.put( "id", "101");
		requestParams.put( "petId","666" );
		requestParams.put( "quantity","1");
		requestParams.put( "status", "placed");
		requestParams.put( "complete", "true");
		
		
		httpRequest.header("content-Type","application/json");
		
		
		Response response=httpRequest.request(Method.POST,"/order");
		System.out.println(response);
		//Print request body in the console
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		
		//validate status code
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		
		
		//validate status line
		
		
		
		
		
	}
}
