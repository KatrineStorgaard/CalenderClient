package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Events;
import shared.Forecast;
import shared.Notes;
import shared.ServerConnection;
import shared.Users;
import shared.Calendar;
import view.CalendarDay;
import view.CalendarSettings;
import view.CalendarWeek;
import view.EventPanel;
import view.Login;
import view._Screen;

public class ActionController implements ActionListener {

	//Declaration of attributes
	private _Screen screen;
	private int selectedDay;
	private int selectedMonth;
	private int selectedEvent;
	Users currentUser = new Users();
	ServerConnection sc = new ServerConnection();
	ClientController cc = new ClientController();
	Events currentEvent = new Events();
	Gson gson = new GsonBuilder().create();
	ArrayList<Events> events = new ArrayList<Events>();
	ArrayList<Calendar> calendars = new ArrayList<Calendar>();

	// constructor
	public ActionController(_Screen screen) {

		this.screen = screen;


	}// end constructor

	/**
	 * This method handles all the action events activated from the JPanels Uses
	 * the method getActionCommand to differentiate between the various action
	 * commands
	 */
	public void actionPerformed(ActionEvent e)  {
		String cmd = e.getActionCommand();

		// if the action command is LOGINSUBMIT
		if (cmd.equals(Login.LOGINSUBMIT)) {

			// takes the info from the txtfields
			String email = screen.getLogin().getTxtremail().getText();
			String password = screen.getLogin().getPasswordField().getText();

			String reply = cc.Login(email, password);

			//If user is logged in
			if (!reply.equals("invalid")){

				currentUser = (Users) gson.fromJson(reply, Users.class);

				screen.setTitle("Week view");
				screen.show(screen.CALENDARWEEK);

				//fetching events
				refreshEvents();
				refreshCalendars();

			}

		} 

		else if(cmd.equals(CalendarWeek.PREVIOUS)){

			if(screen.getCalendarWeek().START_WEEK <= 1){
				screen.getCalendarWeek().START_WEEK = 52;
				screen.getCalendarWeek().START_YEAR--;
				screen.getCalendarWeek().refreshDate(0);
			}else{

				screen.getCalendarWeek().refreshDate(-1);
			}


		}

		else if(cmd.equals(CalendarWeek.NEXT)){
			if(screen.getCalendarWeek().START_WEEK >= 52){
				screen.getCalendarWeek().START_WEEK = 1;
				screen.getCalendarWeek().START_YEAR++;
				screen.getCalendarWeek().refreshDate(0);
			}else{

				screen.getCalendarWeek().refreshDate(+1);
			}
		}

		else if (cmd.equals(CalendarDay.BACK)){
			screen.show(screen.CALENDARWEEK);
			screen.setTitle("Week view");
			screen.getCalendarDay().removeNotefield();
			screen.getCalendarDay().removeNoteLbl();
		}
		else if(cmd.equals(CalendarWeek.SETTINGS)){
			screen.show(screen.CALENDARSETTINGS);
			showTable2();
		}

		else if(cmd.equals(CalendarWeek.QUOTE))
		{
			JOptionPane.showMessageDialog( screen, cc.getQuote());
		}

		else if(cmd.equals(CalendarDay.FORECAST)){
			int selectedYear = screen.getCalendarWeek().START_YEAR;
			String result = cc.getForecast(selectedMonth+1, selectedDay, selectedYear );
			
			Forecast fc = gson.fromJson(result, Forecast.class);
			JOptionPane.showMessageDialog( screen, "Celsius: " + fc.getCelsius() + "\n" + "Description: " + fc.getDesc());
		}

		else if(cmd.equals(CalendarDay.CREATEEVENT)){
			screen.show(screen.EVENTPANEL);
		}
		else if(cmd.equals(EventPanel.CREATEEVENTSUBMIT)){
			
			//setting startTime
			Date startDate = new Date();
			startDate.setYear(screen.getCalendarWeek().START_YEAR);
			startDate.setMonth(selectedMonth);
			startDate.setDate(selectedDay);
			startDate.setHours(Integer.parseInt(screen.getEventPanel().getStartHour().getText()));
			startDate.setMinutes(Integer.parseInt(screen.getEventPanel().getStartMinuts().getText()));
			Timestamp startTimestamp = new Timestamp(startDate.getTime());

			//setting endTime
			Date endDate = new Date();
			endDate.setYear(screen.getCalendarWeek().START_YEAR);
			endDate.setMonth(selectedMonth);
			endDate.setDate(selectedDay);
			endDate.setHours(Integer.parseInt(screen.getEventPanel().getEndHour().getText()));
			endDate.setMinutes(Integer.parseInt(screen.getEventPanel().getEndMinuts().getText()));
			Timestamp endTimestamp = new Timestamp(endDate.getTime());

			cc.createEvent(currentUser.getUserId(), screen.getEventPanel().getTitle().getText(), screen.getEventPanel().getDescription().getText(), startTimestamp, endTimestamp, Integer.parseInt(screen.getEventPanel().getCalendarID().getText()), screen.getEventPanel().getLocationField().getText());

			screen.show(screen.CALENDARWEEK);
			screen.getEventPanel().clearFields();

			refreshEvents();
		}
		else if(cmd.equals(EventPanel.DELETEEVENTSUBMIT)){

			String eventIdString = JOptionPane.showInputDialog(null, "Insert EventID", null);
			cc.deleteEvent(Integer.parseInt(eventIdString));

			refreshEvents();
			screen.getEventPanel().clearFields();
			
			screen.show(screen.CALENDARWEEK);

		}
		
		else if(cmd.equals(EventPanel.CANCEL)){
			screen.show(screen.CALENDARDAY);
		}
 
		else if(cmd.equals(CalendarDay.SHOWNOTE)){

			screen.getCalendarDay().removeTable();
			screen.getCalendarDay().repaint();

			String stringEventId = JOptionPane.showInputDialog(null, "Insert event ID", null);

			selectedEvent = Integer.parseInt(stringEventId); 

			String result = cc.getNote(selectedEvent);

			Notes n = gson.fromJson(result, Notes.class);

			screen.getCalendarDay().getTitle().setText("Note for the Event");

			screen.getCalendarDay().getSetNote().setVisible(true);

			screen.getCalendarDay().getNoteLbl().setVisible(true);

			screen.getCalendarDay().getNoteLbl().setText(n.getText());
			
			screen.getCalendarDay().repaint();
		}
		else if(cmd.equals(CalendarDay.SETNOTE)){
			screen.getCalendarDay().removeTable();
			screen.getCalendarDay().repaint();


			String newNote = JOptionPane.showInputDialog(null, "Insert Note", null);
			
			cc.createNote(selectedEvent, currentUser.getUserId(), newNote);
			
			screen.getCalendarDay().repaint();
			
			screen.getCalendarDay().getNoteLbl().setText(newNote);
			
			
			screen.getCalendarDay().repaint();
				
		}
		else if(cmd.equals(CalendarDay.DELETENOTE)){
			
			
			cc.createNote(selectedEvent, currentUser.getUserId(), "");
			screen.getCalendarDay().getNoteLbl().setText("");
			JOptionPane.showMessageDialog(null, "Note deleted");
		}

		else if(cmd.equals(CalendarSettings.CREATECAL)){
			String calTitle = JOptionPane.showInputDialog(null, "Title", null);
			if(cc.createCalendar(calTitle, currentUser.getUserId()).equals("calendar added")){
				screen.getCalendarDay().removeTable();
				screen.getCalendarDay().repaint();
				JOptionPane.showMessageDialog(null, "Calendar added");
			}
			refreshCalendars();
			showTable2();
			screen.getCalendarDay().repaint();
		}

		else if(cmd.equals(CalendarSettings.DELTECAL)){
			String calIdString = JOptionPane.showInputDialog(null, "Insert ID", null);
			int calIdInt = Integer.parseInt(calIdString);

			if(cc.deleteCalendar(calIdInt, currentUser.getUserId()).equals("calendar deleted")){
				screen.getCalendarDay().removeTable();
				screen.getCalendarDay().repaint();
				JOptionPane.showMessageDialog(null, "Calendar deleted");
			}
			refreshCalendars();
			showTable2();
			screen.getCalendarDay().repaint();

		}

		else if(cmd.equals(CalendarSettings.SHARECAL)){
			String calIdString = JOptionPane.showInputDialog(null, "Insert Calendar-ID", null);
			String userIdString = JOptionPane.showInputDialog(null, "Insert User-ID", null);

			int calIdInt = Integer.parseInt(calIdString);
			int userIdInt = Integer.parseInt(userIdString);

			if(cc.shareCalendar(calIdInt, userIdInt).equals("calendar shared")){
				JOptionPane.showMessageDialog(null, "Calendar shared");
			}
		}
		else if (cmd.equals(CalendarSettings.BACK)){
			screen.show(screen.CALENDARWEEK);
			screen.setTitle("Week view");
			screen.getCalendarDay().removeNotefield();
		}


		else {
			//getting text from button
			String currentDay = cmd;

			//getting selected month 
			int iMid = currentDay.indexOf(screen.getCalendarWeek().MONTHDAYSEPARATOR);
			String monthString = currentDay.substring(0, iMid);

			//setting text from button to specfic month
			int iMonth = 0;
			if(monthString.equals("Jan")){
				iMonth = 0;
			}else if(monthString.equals("Feb")){
				iMonth = 1;
			}else if(monthString.equals("Mar")){
				iMonth = 2;
			}else if(monthString.equals("Apr")){
				iMonth = 3;
			}else if(monthString.equals("May")){
				iMonth = 4;
			}else if(monthString.equals("Jun")){
				iMonth = 5;
			}else if(monthString.equals("Jul")){
				iMonth = 6;
			}else if(monthString.equals("Aug")){
				iMonth = 7;
			}else if(monthString.equals("Sep")){
				iMonth = 8;
			}else if(monthString.equals("Oct")){
				iMonth = 9;
			}else if(monthString.equals("Nov")){
				iMonth = 10;
			}else if(monthString.equals("Dec")){
				iMonth = 11;
			}

			//setting selected 
			int sDay = Integer.parseInt(currentDay.substring(iMid+1, currentDay.length()));
			selectedDay = sDay;
			selectedMonth = iMonth;

			System.out.println(iMonth + "" + sDay);

			showTable(iMonth, sDay);

			screen.getCalendarDay().getTitle().setText("Events for the day");
			screen.setTitle(cmd);
			screen.show(screen.CALENDARDAY);

		}
	}
	public void showTable(int iMonth, int sDay) {

		int space = 0;

		for (int i = 0; i<events.size();i++){
			if(events.get(i).getStartTimestamp().getMonth()== iMonth && events.get(i).getStartTimestamp().getDate() == sDay){
				space++;
			}
		}

		// creates an object with the column names
		String [] columnNames = { "Start", "End", "Cal ID", "Event ID", "Title", "Description", "Location"};

		Object [][] data = new Object [space][7];

		int l = 0;

		for (int i = 0; i < events.size(); i++){

			if(events.get(i).getStartTimestamp().getMonth() == iMonth && events.get(i).getStartTimestamp().getDate() == sDay){

				String start =  events.get(i).getStartTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
				String end = events.get(i).getEndTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();

				data[l][0] =  start;
				data[l][1] = end;
				data[l][2] = events.get(i).getCalendarId();
				data[l][3] = events.get(i).getId();
				data[l][4] = events.get(i).getTitle();
				data[l][5] = events.get(i).getDescription();
				data[l][6] = events.get(i).getLocation();
				l++;	
			}
		}
		screen.getCalendarDay().addTable(data, columnNames);
	}
	public void showTable2(){
		String[] columnNames = {"ID", "Title", "CreatedBy", "Active"};

		Object[][] data = new Object[calendars.size()][4];

		int l = 0;

		for(int i = 0; i <calendars.size(); i++){

			data[l][0] = calendars.get(i).getCalendarid();
			data[l][1] = calendars.get(i).getTitle();
			data[l][2] = calendars.get(i).getUserid();
			data[l][3] = calendars.get(i).isActive();
			l++;
		}


		screen.getCalendarSettings().addTable(data, columnNames);

	}
	public void refreshEvents(){

		events.removeAll(events);
		
		String result = cc.getEvents(currentUser.getUserId());

		Events[] event = gson.fromJson(result, Events[].class);

		for(int i = 0; i < event.length; i++) {

			events.add(event[i]);
		}	
	}

	public void refreshCalendars(){

		calendars.removeAll(calendars);
		
		String response = cc.getCalendars(currentUser.getUserId());
		System.out.println(response);

		Calendar[] calendar = gson.fromJson(response, Calendar[].class);

		for(int i = 0; i < calendar.length; i++){

			calendars.add(calendar[i]);
		}
	}
}// end ActionController class

