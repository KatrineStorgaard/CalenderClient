package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class SimpleCall implements Serializable{

private final long serialVersionUID = 5L;
private String overallID;
private int id;
private String eventId;
private int userId;
private Timestamp date;
private int day;
private int month;
private int year;
private int noteId;
private String text;
private int calendarId;

public SimpleCall(){
	
}
public String getOverallID() {
	return overallID;
}
public void setOverallID(String overallID) {
	this.overallID = overallID;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEventId() {
	return eventId;
}
public void setEventid(String eventId) {
	this.eventId = eventId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public long getSerialVersionUID() {
	return serialVersionUID;
}

public int getNoteId() {
	return noteId;
}
public void setNoteId(int noteId) {
	this.noteId = noteId;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getCalendarId() {
	return calendarId;
}
public void setCalendarId(int calendarId) {
	this.calendarId = calendarId;
}
@Override
public String toString() {
	return "SimpleCall [serialVersionUID=" + serialVersionUID + ", overallID="
			+ overallID + ", id=" + id + ", eventid=" + eventId + ", userId="
			+ userId + ", date=" + date + ", day=" + day + ", month=" + month
			+ ", year=" + year + "]";
}


	
}
