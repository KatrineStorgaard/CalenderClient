package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class Events implements Serializable {
	
	private  final long serialVersionUID = 3L;
	private String overallID;
    private String description;
    private String title;
    private String location;
    private int startTimestamp;
    private int endTimestamp;
    private boolean active;
    
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
	public int getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(int startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public int getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(int endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
 
    
    
}
