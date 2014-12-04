package logic;

import gui.CalendarDay;
import gui.CalendarWeek;
import gui.CreateEvent;
import gui.Login;
import gui._Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Events;
import shared.Forecast;
import shared.Notes;
import shared.ObjectTranslator;
import shared.ServerConnection;
import shared.Users;

public class ActionController implements ActionListener {
	
	//Declaration of attributes
	private _Screen screen;
	private Controller co;
	private int selectedDay;
	private int selectedMonth;
	Users currentUser = new Users();
	ServerConnection sc = new ServerConnection();
	ObjectTranslator ot = new ObjectTranslator();
	Events currentEvent = new Events();
	Gson gson = new GsonBuilder().create();
	ArrayList<Events> events = new ArrayList<Events>();
	
	// constructor
	public ActionController(_Screen screen) {

		this.screen = screen;
		this.co = new Controller();
		this.ot = new ObjectTranslator();
		

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
					
					// parses username and password to the method login
					System.out.println(email + " " + password);
					
					try {
					
						String reply = ot.Login(email, password);

						if (!reply.equals("invalid")){
							
							currentUser = (Users) gson.fromJson(reply, Users.class);
							
							screen.setTitle("Week view");
							screen.show(screen.CALENDARWEEK);
							
							String result = ot.getEvents(currentUser.getUserId());
							
							Events [] event = gson.fromJson(result, Events[].class);
							
							for ( int i = 0; i<event.length; i ++){
								
								events.add(event[i]);
							}
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
				else if(cmd.equals(CalendarWeek.PREVIOUS)){
					
					screen.getCalendarWeek().refreshDate(-1);
				}
				
				else if(cmd.equals(CalendarWeek.NEXT)){
					screen.getCalendarWeek().refreshDate(+1);
				}
				
				else if (cmd.equals(CalendarDay.BACK)){
					screen.show(screen.CALENDARWEEK);
					screen.setTitle("Week view");
				}
				
				else if(cmd.equals(CalendarWeek.QUOTE))
				{
					JOptionPane.showMessageDialog( screen, sc.connect("getQuote"));
				}
				
				if(cmd.equals(CalendarDay.FORECAST)){
					
					screen.getCalendarDay().removeTable();
					screen.getCalendarDay().repaint();
					
					String result = ot.getForecact(selectedMonth+1, selectedDay);
					Forecast fc = gson.fromJson(result, Forecast.class);
					screen.getCalendarDay().getTitle().setText("forecast for today");
					screen.getCalendarDay().getDate().setText(fc.getDate());
					screen.getCalendarDay().getDate().setVisible(true);
					screen.getCalendarDay().getCelsius().setText(fc.getCelsius());
					screen.getCalendarDay().getCelsius().setVisible(true);
					screen.getCalendarDay().getDesc().setText(fc.getDesc());
					screen.getCalendarDay().getDesc().setVisible(true);
				}
				else if(cmd.equals(CalendarDay.CREATEEVENT)){
					screen.show(screen.CREATEEVENT);
				}
				else if(cmd.equals(CreateEvent.CREATEEVENTSUBMIT)){
					String title = screen.getCreateEvent().getTitle().getText();
					String location = screen.getCreateEvent().getaLocation().getText();
					String description = screen.getCreateEvent().getDescription().getText();
					String start = screen.getCreateEvent().getStart().getText();
					String end = screen.getCreateEvent().getEnd().getText();
					System.out.println(title+" "+location+" "+description+" "+start+" "+end );
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
					Date parsedDate = null;
					try {
						parsedDate = (Date) dateFormat.parse(start);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Timestamp startTimestamp = new Timestamp(parsedDate.getTime());
					System.out.println(startTimestamp);
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
					Date parsedDate1 = null;
					try {
						parsedDate1 = (Date) dateFormat1.parse(end);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Timestamp endTimestamp = new Timestamp(parsedDate1.getTime());
					System.out.println(endTimestamp);
				  ot.createEvent(description, startTimestamp, endTimestamp, location, title); 
					}
	
				
				else if(cmd.equals(CalendarDay.SHOWNOTE)){
					
					screen.getCalendarDay().removeTable();
					screen.getCalendarDay().repaint();
					
					String result = ot.getNote(42);
					Notes n = gson.fromJson(result, Notes.class);
					
					screen.getCalendarDay().getTitle().setText(n.getText());
					screen.getCalendarDay().getSetNote().setVisible(true);
				
				}
				
				else {
					String currentDay = cmd;
					
					int iMid = cmd.indexOf(screen.getCalendarWeek().getMONTHDAYSEPARATOR());
					String monthString = currentDay.substring(0, iMid);
					
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
	}// end actionPerformed
}// end ActionController class
	
