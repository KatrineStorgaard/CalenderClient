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


//	public String checklog(String email, String password) {
//		users.setEmail(email);
//		users.setPassword(password);
//		//users.setActive(true);
//		users.setOverallID("logIn");
//		String gsonString = gson.toJson(users);
//		System.out.println(gsonString);
//		
//		return sc.connect(gsonString);		
//	}
	
	public String Login(String email, String password){
		System.out.println("login koerer");
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		String gsonString = gson.toJson(currentUser);

		
		return sc.connect(gsonString);		
	}
	
	public String getEvents( int userId) {
		sim.setOverallID("getEvents");
		sim.setUserId(userId);
		System.out.println(sim.toString());
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
	}
	
	public String getForecact(int month, int day){
		
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
	
	
	public String createEvent(String description, Timestamp startTimestamp, Timestamp endTimestamp, String location, String title ){
		events.setOverallID("getEvent");
		events.setDescription(description);
		events.setStartTimestamp(startTimestamp);
		events.setEndTimestamp(endTimestamp);
		events.setLocation(location);
		events.setTitle(title);
		events.setActive(true);
		events.setOverallID("createEvent");
		String gsonString = gson.toJson(events);
		return sc.connect(gsonString);
	}

	public String createNote(int noteId, int id, int createdBy, String text) {
		
		sim.setOverallID("createNote");
		sim.setNoteId(noteId);
		sim.setId(id);
		sim.setUserId(createdBy);
		sim.setText(text);
		
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
	}
	

}
