package logic;

import gui.CalendarWeek;
import gui.CreateEvent;
import gui.Login;
import gui._Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;

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
	Users currentUser = new Users();
	ServerConnection sc = new ServerConnection();
	ObjectTranslator ot = new ObjectTranslator();
	Gson gson = new GsonBuilder().create();
	
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
							
//							String result = ot.getEvents(result, Event[].class);
							
//							for ( int i = 0, i<event.length; i ++){
//								
//								events.add(event[i]);
//								System.out.println("Event added");
//							}
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
				
				else if(cmd.equals(CalendarWeek.QUOTE))
				{
					JOptionPane.showMessageDialog( screen, sc.connect("getQuote"));
				}
	}// end actionPerformed
}// end ActionController class
	
