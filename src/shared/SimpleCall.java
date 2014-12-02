package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class SimpleCall implements Serializable{

private final long serialVersionUID = 5L;
private String overallID;
private int id;
private String eventid;
private int userId;
private Timestamp date;
private int day;
private int month;
private int year;

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
public String getEventid() {
	return eventid;
}
public void setEventid(String eventid) {
	this.eventid = eventid;
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
@Override
public String toString() {
	return "SimpleCall [serialVersionUID=" + serialVersionUID + ", overallID="
			+ overallID + ", id=" + id + ", eventid=" + eventid + ", userId="
			+ userId + ", date=" + date + ", day=" + day + ", month=" + month
			+ ", year=" + year + "]";
}


	
}
