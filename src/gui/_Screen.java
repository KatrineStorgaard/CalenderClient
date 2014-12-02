package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import logic.ActionController;



public class _Screen extends JFrame {


	//Declaration of global style constants
	public static final int WIDTH = 600;
	public static final int HEIGHT = 250;

	//Declaration of attributes
	private ActionController actionController;
	private Login login;
	private JPanel contentPane;
	private CardLayout c;
	private CalendarWeek calendarWeek;
	private CalendarDay calendarDay;
	private CreateEvent createEvent;
	private CreateNote createNote;

	// Declaration of constants
	public static final String LOGIN = "login";
	public static final String CALENDARWEEK ="calendarWeek";
	public static final String CALENDARDAY = "calendarDay";
	public static final String CREATEEVENT = "createEvent";
	public static final String CREATENOTE = "createNote";

	
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
		createNote = new CreateNote(actionController);
		createEvent = new CreateEvent(actionController);		

		//adding JPanels to the contentPane
		contentPane.add(login, LOGIN);
		contentPane.add(calendarWeek, CALENDARWEEK);
		contentPane.add(createNote, CREATENOTE);
		contentPane.add(createEvent, CREATEEVENT);
		contentPane.add(calendarDay, CALENDARDAY);
		
		
		


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

	public CreateEvent getCreateEvent(){
		return createEvent;
		
	}
	
	public CreateNote getCreateNote(){
		return createNote;
	}
	
	

}// end class _Screen
