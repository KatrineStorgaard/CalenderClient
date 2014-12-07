package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import shared.ServerConnection;
import logic.ActionController;

public class CalendarWeek extends JPanel{

	private CalendarWeek wk;
	private ActionController actionController;
	private _Screen screen;
	GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
	GregorianCalendar cal2;
	private JButton[] button = new JButton[7];
	private JLabel ugenr;
	private JButton forward;
	private JButton back;
	private JTextField uge;
	private JButton go;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	public static int START_WEEK;
	public static int START_YEAR;
	public static String MONTHDAYSEPARATOR =" ";

	//Declaration of panel constants
	public static final String PREVIOUS = "Previous";
	public static final String NEXT = "Next";
	public static final String QUOTE ="Quote";
	public static final String SETTINGS ="Settings";
	private JButton btnQuote;
	private JButton btnSettings;



	public CalendarWeek(ActionController actionController)
	{

		this.actionController = actionController;
		ServerConnection sc = new ServerConnection();

		START_WEEK = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		START_YEAR = cal.get(GregorianCalendar.YEAR);


		setLayout(new BorderLayout());
		p1 = new JPanel(new GridLayout(0,7));
		p1.setBackground(Color.PINK);
		p1.setVisible(true);
		add(p1, BorderLayout.NORTH);

		String[] headers = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

		for(int i = 0; i <7; i++){
			JLabel l = new JLabel(("" + headers[i]), SwingConstants.CENTER);
			p1.add(l, new GridLayout(2,7));
		}

		p2 = new JPanel(new GridLayout(0,7));
		p2.setBackground(Color.PINK);
		p2.setVisible(true);
		add(p2, BorderLayout.CENTER);

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.red);
			p2.add(button[x], new GridLayout(2,7));

		}

		displayDate2(START_WEEK,START_YEAR);

		p3 = new JPanel(new GridLayout(1,5));
		p3.setBackground(Color.PINK);
		p3.setVisible(true);
		
		back = new JButton("<< Previous");
		back.addActionListener(actionController);
		back.setActionCommand(PREVIOUS);
		p3.add(back);
		
		ugenr = new JLabel("Ugenr:");
		p3.add(ugenr);
		
		uge = new JTextField(""+ START_WEEK);
		p3.add(uge);
		
		go = new JButton("Go to week");
		p3.add(go);
		
		forward = new JButton("Next >>");
		forward.addActionListener(actionController);
		forward.setActionCommand(NEXT);
		p3.add(forward);
		add(p3, BorderLayout.SOUTH);

		btnQuote = new JButton("Quote");
		p3.add(btnQuote);
		btnQuote.addActionListener(actionController);
		btnQuote.setActionCommand(QUOTE);
		
		btnSettings = new JButton("Calendar Settings");
		p3.add(btnSettings);
		btnSettings.addActionListener(actionController);
		btnSettings.setActionCommand(SETTINGS);
	}



	public void displayDate2(int weekNumber, int yearNumber){

		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
		cal.set(Calendar.YEAR, yearNumber);


		int iMonth, iDay;

		for (int x = 0; x <  button.length; x++){
			iMonth =  cal.get(Calendar.MONTH);
			iDay = cal.get(Calendar.DAY_OF_MONTH);
			switch(iMonth){
			case 0: button[x].setText("Jan" + MONTHDAYSEPARATOR + (iDay) );break;
			case 1:button[x].setText("Feb" + MONTHDAYSEPARATOR + (iDay) );break;
			case 2:button[x].setText("Mar" + MONTHDAYSEPARATOR + (iDay) );break;
			case 3:button[x].setText("Apr" + MONTHDAYSEPARATOR + (iDay) );break;
			case 4:button[x].setText("Maj" + MONTHDAYSEPARATOR + (iDay) );break;
			case 5:button[x].setText("Jun" + MONTHDAYSEPARATOR + (iDay) );break;
			case 6:button[x].setText("Jul" + MONTHDAYSEPARATOR + (iDay) );break;
			case 7:button[x].setText("Aug" + MONTHDAYSEPARATOR + (iDay) );break;
			case 8:button[x].setText("Sep" + MONTHDAYSEPARATOR + (iDay) );break;
			case 9:button[x].setText("Okt" + MONTHDAYSEPARATOR + (iDay) );break;
			case 10:button[x].setText("Nov" + MONTHDAYSEPARATOR + (iDay) );;break;
			case 11:button[x].setText("Dec" + MONTHDAYSEPARATOR + (iDay) );break;
			}
			cal.add(Calendar.DATE, 1);

			button[x].addActionListener(actionController);
		}

	}


	public void refreshDate(int newWeek){


		START_WEEK =  START_WEEK + newWeek;
		displayDate2(START_WEEK,START_YEAR);

		String stringNextWeek = String.valueOf(START_WEEK);
		String stringNextYear = String.valueOf(START_YEAR);
		uge.setText(stringNextWeek);		

	}
	public static String getMONTHDAYSEPARATOR() {
		return MONTHDAYSEPARATOR;
	}


	public static void setMONTHDAYSEPARATOR(String mONTHDAYSEPARATOR) {
		MONTHDAYSEPARATOR = mONTHDAYSEPARATOR;
	}

}
