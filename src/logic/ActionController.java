package logic;

import gui.Login;
import gui._Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
					String username = screen.getLogin().getTxtremail().getText();
					String password = screen.getLogin().getPasswordField().getText();
					// parses username and password to the method login
					System.out.println(username + password);
					Users currentUser = co.checklog(username, password);

					// if the entered info is validated
					if (currentUser != null) {
						
							}// end if
								// if user status is false
							else {
								JOptionPane.showMessageDialog(screen,
										"Your user is inactive");
							}// end else
						}// end if

	}// end actionPerformed
}// end ActionController class
	
