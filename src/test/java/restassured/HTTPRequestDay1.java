package restassured;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequestDay1 {
	int id;
//@Test(priority=1)	
   void getUser() {
	given()
	
	.when()
	  .get("https://reqres.in/api/users?page=2") 
	
	.then()
	  .statusCode(200)
	  .body("page", equalTo(2)) 
	 // .body("page", equalsTo(2))
	  .log().all();
	  
}
@Test(priority=2)
void createUser() {
	HashMap data=new HashMap();
	 data.put("name", "nistha");
     data.put("job", "CEO");
     id = given()
             .contentType("application/json") // Correct content type
             .body(data)
         .when()
             .post("https://reqres.in/api/users")
             .jsonPath().getInt("id");
	
	
	//.then()}
}
}
