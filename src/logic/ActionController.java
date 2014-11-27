package logic;

import gui.CalendarWeek;
import gui.CreateEvent;
import gui.Login;
import gui._Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import shared.Events;
import shared.Users;

public class ActionController implements ActionListener {
	
	//Declaration of attributes
	private _Screen screen;
	private Controller co;

	// constructor
	public ActionController(_Screen screen) {

		this.screen = screen;
		this.co = new Controller();

	}// end constructor

	/**
	 * This method handles all the action events activated from the JPanels Uses
	 * the method getActionCommand to differentiate between the various action
	 * commands
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// if the action command is LOGINSUBMIT
				if (cmd.equals(Login.LOGINSUBMIT)) {
					// takes the info from the txtfields
					String email = screen.getLogin().getTxtremail().getText();
					String password = screen.getLogin().getPasswordField().getText();
					// parses username and password to the method login
					System.out.println(email + password);
					String answer = co.checklog(email, password);

					// if the entered info is validated
					if (answer.equalsIgnoreCase("Login Successful")) {
						System.out.println("DU ER LOGGET INDDNDNDN");
							}// end if
								// if user status is false
							else {
								JOptionPane.showMessageDialog(screen,
										"Something went wrong");
							}// end else
						}// end if
//				if (cmd.equals(CreateEvent.CREATEEVENTSUBMIT)){
//					String title = screen.getCreateEvent().getTextTitle().getText();
//					String location = screen.getCreateEvent().getTextLocation().getText();
//					String description = screen.getCreateEvent().getTextDescription().getText();
//					String startTimestamp = screen.getCreateEvent().getTextStart().getText();
//					String endTimestamp = screen.getCreateEvent().getTextEnd().getText();
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
	}// end actionPerformed
}// end ActionController class
	
