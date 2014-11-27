package shared;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectTranslator {

	Users users  = new Users();
	Events events = new Events();
	Gson gson = new GsonBuilder().create();
	TCPClient tcpClient = new TCPClient();
	
	public ObjectTranslator() {
		
	}

	public String checklog(String email, String password) {
		users.setEmail(email);
		users.setPassword(password);
		users.setActive(true);
		users.setOverallID("logIn");
		String gsonString = gson.toJson(users);
		System.out.println(gsonString);
		
		return tcpClient.connect(gsonString);		
	}
	
	public void createEvent(String description, Timestamp startTimestamp, Timestamp endTimestamp, String location, String title ){
		events.setDescription(description);
		events.setStartTimestamp(startTimestamp);
		events.setEndTimestamp(endTimestamp);
		events.setLocation(location);
		events.setTitle(title);
		events.setActive(true);
		events.setOverallID("createEvent");
		String gsonString = gson.toJson(events);
		tcpClient.connect(gsonString);
	}
	

}
