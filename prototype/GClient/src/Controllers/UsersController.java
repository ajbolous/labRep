package Controllers;
import ClientUI.Application;
import Users.User;
import Utils.Request;
public class UsersController {
	
	public User getUser(String id) throws Exception
	{
		Request r = new Request("users/byId");
		r.addParam("id", id);
		
		User u = (User)Application.client.Request(r);
		
		if(u == null){
			
			throw new Exception();
		}
		return u;
	
	
	}
	
	public boolean authenticateUser(String id, String pass){
		User u = getUser(id);
		
		if(u == null)
			return false;

		if(u.getPassword().equals(pass))
			return true;
		
		return false;
		
	}

}


