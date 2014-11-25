package logic;

import shared.ObjectTranslator;
import shared.Users;

public class Controller {
	
	
	
	private ObjectTranslator ot = new ObjectTranslator();
	private Users currentUser;

	public Controller() {
		
	}
	
	public Users checklog(String username, String password) {
	
		ot.checklog(username, password);
		
	
		return currentUser;
	}

}
