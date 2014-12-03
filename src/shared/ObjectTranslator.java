package shared;

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
	
	public String Login(String email, String password) throws Exception {
		System.out.println("login koerer");
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		//users.setActive(true);
//		currentUser.setOverallID("logIn");
		String gsonString = gson.toJson(currentUser);
//		System.out.println(gsonString);
		
		return sc.connect(gsonString);		
	}
	
	public String getEvents( int userId) throws Exception{
		sim.setOverallID("getEvents");
		sim.setUserId(userId);
		System.out.println(sim.toString());
		String gsonString = gson.toJson(sim);
		
		return sc.connect(gsonString);
	}
	
	
//	public void createEvent(String description, Timestamp startTimestamp, Timestamp endTimestamp, String location, String title ){
//		events.setDescription(description);
//		events.setStartTimestamp(startTimestamp);
//		events.setEndTimestamp(endTimestamp);
//		events.setLocation(location);
//		events.setTitle(title);
//		events.setActive(true);
//		events.setOverallID("createEvent");
//		String gsonString = gson.toJson(events);
//		sc.connect(gsonString);
//	}
	

}
