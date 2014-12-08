package logic;

import java.sql.Timestamp;

//import shared.Events;
import shared.ObjectTranslator;
import shared.Users;

public class ClientController {
	
	
	
	private ObjectTranslator ot = new ObjectTranslator();
	Users currentUser = new Users();
//	private Events ec;

	public ClientController() {
		
	}
	
	public String Login(String email, String password) {
	
		return ot.Login(email, password);
			
	}
	
	public String createEvent(int createdby, String title, String description, Timestamp start, Timestamp end,  int calendarId ,String location){

		return ot.createEvent(createdby, title, description, start, end, calendarId, location);
	}
	
	public String getCalendars(int userId){
		
		return ot.getCalendars(userId);
	}
	
	public String createCalendar(String title, int userID){
		
		return ot.createCalendar(title, userID);
	}
	
	public String deleteCalendar(int calId, int userId){
		
		return ot.deleteCalendar(calId, userId);
	}
	
	public String shareCalendar(int calId, int userId){
		
		return ot.shareCalendar(calId, userId);
	}
	
	public String getEvents(int userId) {
		
		return ot.getEvents(userId);
	}
	
	public String getForecast(int month, int day){
		
		return ot.getForecast(month, day);
	}
	
	public String getNote(int id){
		
		return ot.getNote(id);
	}
	
	public String getQuote(){
		
		return ot.getQuote();
	}	

	public String createNote(int id, int createdBy, String text) {
		
		return ot.createNote(id, createdBy, text);
	}
	
	public String deleteEvent(int eventId) {
		
		return ot.deleteEvent( eventId);
	}

}