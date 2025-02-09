	package api.test;
	
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	import api.endpoint.userEndPoints;
	import api.payload.User;
	import api.utilities.DataProviders;
	import io.restassured.response.Response;
	
	public class DDTests {
		@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class )
		public void testPostUser(String userId, String username, String fname, String lname, String useremail, String password, String phone)
		{
			User userPayload=new User();
			userPayload.setId(Integer.parseInt(userId));
			userPayload.setUsername(username);
			userPayload.setFirstname(fname);
			userPayload.setLastname(lname);
			userPayload.setEmail(useremail);
			userPayload.setPassword(password);
			userPayload.setPhone(phone);
			
			Response response=userEndPoints.createUser(userPayload);
			Assert.assertEquals(response.getStatusCode(), 200);
		}
	    @Test(priority=4,dataProvider="UserNames", dataProviderClass=DataProviders.class)
		public void testDeleteUserByName(String username) {
	    	Response response=userEndPoints.deleteUser(username);
	    	Assert.assertEquals(response.getStatusCode(), 200);
	    }
	    @Test(priority=2,dataProvider="UserNames", dataProviderClass=DataProviders.class)
	    public void testGetUserByName(String username) {
	        Response response = userEndPoints.readUser(username);
	    	Assert.assertEquals(response.getStatusCode(), 200);
	    	
	    }
	    @Test(priority=3,dataProvider="Data", dataProviderClass=DataProviders.class)
	    public void testUpdateUserByName(String userId, String username, String fname, String lname, String email, String password, String phone) {
	        User userPayload = new User();
	        userPayload.setId(Integer.parseInt(userId));
	        userPayload.setUsername(username);
	        userPayload.setFirstname(fname);
	        userPayload.setLastname(lname);
	        userPayload.setEmail(email);
	        userPayload.setPassword(password);
	        userPayload.setPhone(phone);
	    	Response response=userEndPoints.updateUser(username, userPayload);
	    	Assert.assertEquals(response.getStatusCode(), 200);
	    	
   }
	
	}
