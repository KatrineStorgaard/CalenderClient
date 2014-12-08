package shared;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Events implements Serializable {
	
	private  final long serialVersionUID = 3L;
	private String overallID;
    private String description;
    private String title;
    private String location;
    private Timestamp ts;
    private ArrayList <String> start;
    private Timestamp startTimestamp;
    private ArrayList <String> end;
    private Timestamp endTimestamp;
    private boolean active;
    private String eventid;
    private int calendarId;
    private int id;
    private int createdby;
    private String type;

    public Events(int id, String eventid, int calendarId, int createdby,
			String title, String description, String location, Timestamp start, Timestamp end, String type, boolean active) {
		super();
		this.id = id;
		this.eventid = eventid;
		this.calendarId = calendarId;
		this.createdby = createdby;
		this.description = description;
		this.title = title;
		this.location = location;
		this.startTimestamp = start;
		this.endTimestamp = end;
		this.type = type;
		this.active = active;
	}
    public Events(){
    	
    }
    
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
	public int getCreatedBy() {
		return createdby;
	}
	public void setCreatedBy(int createdBy) {
		this.createdby = createdBy;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public ArrayList<String> getStart() {
		return start;
	}
	public void setStart(ArrayList<String> start) {
		this.start = start;
	}
	public ArrayList<String> getEnd() {
		return end;
	}
	public void setEnd(ArrayList<String> end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Events [serialVersionUID=" + serialVersionUID + ", overallID="
				+ overallID + ", description=" + description + ", title="
				+ title + ", location=" + location + ", ts=" + ts + ", start="
				+ start + ", startTimestamp=" + startTimestamp + ", end=" + end
				+ ", endTimestamp=" + endTimestamp + ", active=" + active
				+ ", eventid=" + eventid + ", calendarId=" + calendarId
				+ ", id=" + id + ", createdBy=" + createdby + ", type=" + type
				+ "]";
	}
 
    
    
}
