package shared;

import java.sql.Timestamp;

public class Notes {

	private int noteID;
	private int id;
	private int createdBy;
	private String text;
	private Timestamp created;
	private boolean isActive;
	private String overallID;
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	
}
