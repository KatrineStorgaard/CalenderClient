package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class Events implements Serializable {
	
	private  final long serialVersionUID = 3L;
	private String overallID;
    private String description;
    private String title;
    private String location;
    private Timestamp startTimestamp;
    private Timestamp endTimestamp;
    private boolean active;
    private String eventid;
    private int calendarId;
    private int id;
    
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public Timestamp getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
 
    
    
}
