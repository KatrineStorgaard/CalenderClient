package logic;

import java.sql.Timestamp;

import shared.Events;
import shared.ObjectTranslator;
import shared.Users;

public class Controller {
	
	
	
	private ObjectTranslator ot = new ObjectTranslator();
	private Users currentUser;
	private Events ec;

	public Controller() {
		
	}
	
	public Users checklog(String username, String password) {
	
		ot.checklog(username, password);
		
	
		return currentUser;
	}
	
	public Events createEvent(String description, int startTimestamp, int endTimestamp, String location, String title){
		
		ot.createEvent(description, startTimestamp, endTimestamp, location, title);
		
		return ec;
	}

}
