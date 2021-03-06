package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import logic.ActionController;



public class _Screen extends JFrame {


	//Declaration of global style constants
	public static final int WIDTH = 900;
	public static final int HEIGHT = 400;

	//Declaration of attributes
	private ActionController actionController;
	private Login login;
	private JPanel contentPane;
	private CardLayout c;
	private CalendarWeek calendarWeek;
	private CalendarDay calendarDay;
	private EventPanel eventPanel;
	private CalendarSettings calendarSettings;

	// Declaration of constants
	public static final String LOGIN = "login";
	public static final String CALENDARWEEK ="calendarWeek";
	public static final String CALENDARDAY = "calendarDay";
	public static final String EVENTPANEL = "eventPanel";
	public static final String CALENDARSETTINGS = "calendarSettings";

	
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
		login = new Login(actionController);
		calendarWeek = new CalendarWeek(actionController);
		calendarDay = new CalendarDay(actionController);
		eventPanel = new EventPanel(actionController);	
		calendarSettings = new CalendarSettings(actionController);

		//adding JPanels to the contentPane
		contentPane.add(login, LOGIN);
		contentPane.add(calendarWeek, CALENDARWEEK);
		contentPane.add(eventPanel, EVENTPANEL);
		contentPane.add(calendarDay, CALENDARDAY);
		contentPane.add(calendarSettings, CALENDARSETTINGS);
		
		
		


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
	
	public CalendarDay getCalendarDay(){
		return calendarDay;
	}

	public EventPanel getEventPanel(){
		return eventPanel;
		
	}
	
	public CalendarSettings getCalendarSettings(){
		return calendarSettings;
	}
	

}// end class _Screen
