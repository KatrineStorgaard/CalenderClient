package gui;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logic.ActionController;



public class _Screen extends JFrame {


	//Declaration of global style constants
	public static final int WIDTH = 266;
	public static final int HEIGHT = 400;

	//Declaration of attributes
	private ActionController actionController;
	private Login login;
	private JPanel contentPane;
	private CardLayout c;
	private CalendarWeek calendarWeek;
	private CreateEvent createEvent;

	// Declaration of constants
	public static final String LOGIN = "login";
	public static final String CALENDARWEEK ="calendarWeek";
	public static final String CREATEEVENT = "createEvent";

	// no-argument constructor
	public _Screen()
	{
		setSize(WIDTH, HEIGHT);
		actionController = new ActionController(this);

		//adding the contentPane
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		c = (CardLayout) getContentPane().getLayout();

		//instances of the JPanels 
		createEvent = new CreateEvent(actionController);
		login = new Login(actionController);
		calendarWeek = new CalendarWeek(actionController);

		//adding JPanels to the contentPane
		//contentPane.add(createEvent, CREATEEVENT);
		contentPane.add(calendarWeek, CALENDARWEEK);
		contentPane.add(login, LOGIN);
		
		


	}//end constructor




	/**
	 * Show the given card 
	 * @param Name of the assigned actioncmd
	 */
	public void show(String card)
	{
		c.show(getContentPane(), card);
	}

	/**
	 * creating get methods for the JPanels 
	 */

	public Login getLogin(){
		return login;
	}

	public CalendarWeek getCalendarWeek(){
		return calendarWeek;
	}

	public CreateEvent getCreateEvent(){
		return createEvent;
		
	}

}// end class _Screen
