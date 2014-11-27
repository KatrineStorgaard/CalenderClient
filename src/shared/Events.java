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
	public String getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(String startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public String getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(String endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
 
    
    
}
