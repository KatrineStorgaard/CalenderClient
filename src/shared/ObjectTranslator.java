package shared;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectTranslator {

	Events events = new Events();
	Gson gson = new GsonBuilder().create();
	ServerConnection sc = new ServerConnection();
	SimpleCall sim = new SimpleCall();
	Users currentUser  = new Users();
	Calendar cal = new Calendar();
	Notes notes = new Notes();
	
	public String Login(String email, String password){
		System.out.println("login koerer");
		currentUser.setEmail(email);
		System.out.println(email);
		currentUser.setPassword(password);
		System.out.println(password);
		System.out.println(email+password);
		String gsonString = gson.toJson(currentUser);
		
		
		return sc.connect(gsonString);		
	}
	
	public String getCalendars(int userId){
		cal.setOveralleID("getCalendars");
		cal.setUserid(userId);
		
		String gsonString = gson.toJson(cal);
		return sc.connect(gsonString);
		
	}
	
	public String createCalendar(String title, int userID){
		cal.setOveralleID("createCalendar");
		cal.setTitle(title);
		cal.setUserid(userID);
		
		String gsonString = gson.toJson(cal);
		
		return sc.connect(gsonString);
	}
	
	public String deleteCalendar(int calId, int userId){
		cal.setOveralleID("deleteCalendar");
		cal.setCalendarid(calId);
		cal.setUserid(userId);
		
		String gsonString = gson.toJson(cal);
		return sc.connect(gsonString);
	}
	
	public String shareCalendar(int calId, int userId){
		sim.setOverallID("shareCalendar");
		sim.setCalendarId(calId);
		sim.setUserId(userId);
		
		String gsonString = gson.toJson(sim);
		return sc.connect(gsonString);
	}
	
	
	
	public String getEvents( int userId) {
		sim.setOverallID("getEvents");
		sim.setUserId(userId);
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
	}
	
	public String getForecast(int month, int day){
		
		sim.setOverallID("getForecast");
		sim.setYear(2014);
		sim.setMonth(month);
		sim.setDay(day);
		
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
	}
	
	public String getNote(int id){
		sim.setOverallID("getNote");
		sim.setId(id);
		String gsonString = gson.toJson(sim);
		return sc.connect(gsonString);
	}
	
	public String getQuote(){
		sim.setOverallID("getQuote");
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
	}
	
	public String createEvent( int createdby, String title, String description, Timestamp start, Timestamp end,  int calendarId ,String location  ){
		events.setOverallID("createEvent");
		events.setDescription(description);
		events.setStartTimestamp(start);
		events.setEndTimestamp(end);
		events.setLocation(location);
		events.setTitle(title);
		System.out.println(createdby);
		events.setCreatedBy(createdby);
		events.setCalendarId(calendarId);
		//System.out.println(description + start+end+location+title+createdBy+calendarId);
		System.out.println(events.toString());
		
		String gsonString = gson.toJson(events, Events.class);
		
		return sc.connect(gsonString);
	}

	public String createNote(int id, int createdBy, String text) {
		
		notes.setOverallID("createNote");
		notes.setCreatedBy(createdBy);
		notes.setEventID(id);
		notes.setText(text);
		
		String gsonString = gson.toJson(notes);
		
		return sc.connect(gsonString);
	}
	
	public String deleteEvent(int eventId){
		sim.setOverallID("deleteEvent");
		sim.setId(eventId);
		
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
		
	}
	
	

}
