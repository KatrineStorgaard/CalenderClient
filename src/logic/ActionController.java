package logic;

import gui.CalendarDay;
import gui.CalendarWeek;
import gui.Login;
import gui._Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Events;
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
								System.out.println("Event added");
							}
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
					// if the entered info is validated
//					if (answer.equalsIgnoreCase("Login Successful")) {
//						screen.show(screen.CALENDARWEEK);
//							}// end if
//								// if user status is false
//							else {
//								JOptionPane.showMessageDialog(screen,
//										"Something went wrong");
//							}// end else
//						}// end if
//				if (cmd.equals(CreateEvent.CREATEEVENTSUBMIT)){
//					String title = screen.getCreateEvent().getTextTitle().getText();
//					String location = screen.getCreateEvent().getTextLocation().getText();
//					String description = screen.getCreateEvent().getTextDescription().getText();
//					String sT = screen.getCreateEvent().getTextStart().getText();
//					String eT = screen.getCreateEvent().getTextEnd().getText();
//					System.out.println(title + location + description + startTimestamp+ endTimestamp);
//					
//					Events ec = co.createEvent(description, startTimestamp, endTimestamp, location, title);
//				}
				
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
	
