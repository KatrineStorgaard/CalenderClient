package logic;

import shared.Events;
import shared.ObjectTranslator;
import shared.Users;

public class Controller {
	
	
	
	private ObjectTranslator ot = new ObjectTranslator();
	private Users currentUser;
	private Events ec;

	public Controller() {
		
	}
	
	public String Login(String email, String password) throws Exception {
	
		return ot.Login(email, password);
			
	}
	
//	public Events createEvent(String description, Timestamp startTimestamp, Timestamp endTimestamp, String location, String title){
//		
//		ot.createEvent(description, startTimestamp, endTimestamp, location, title);
//		return ec;
//	}


}
