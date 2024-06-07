package api.endpoints;

//CURD operations
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	
	public static ResourceBundle getURL() {
		
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //Load properties file
		return routes;
	}
	
	
	
	
	public static Response createUser(User payload){
		
		String postURL= getURL().getString("post_url");
		
		
		Response response= given()
				.contentType("application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.accept("application/json")	
				.body(payload)
		.when()
				.post(postURL);	
		return response;
	}
	
	
	public static Response readUser(String userName){
		
		String getURL= getURL().getString("get_url");
		
		Response response= given()
				.pathParam("username", userName)
		.when()
				.get(getURL);	
		return response;
	}
	
	
	
	public static Response updateUser(String userName,User payload){
		
		String updateURL= getURL().getString("update_url");
		
		Response response= given()
				.contentType("application/json")
				.accept("application/json")	
				.pathParam("username", userName)
				.body(payload)
		.when()
				.put(updateURL);	
		return response;
	}
	
	
	
	public static Response deleteUser(String userName){
		
		String deleteURL= getURL().getString("delete_url");
		
		Response response= given()
				.pathParam("username", userName)
		.when()
				.delete(deleteURL);	
		return response;
	}
	

}
