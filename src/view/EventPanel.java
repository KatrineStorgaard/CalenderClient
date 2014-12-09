package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import logic.ActionController;

public class EventPanel extends JPanel{
	private JTextField title;
	private JTextField locationField;
	private JTextField description;
	private JTextField startHour;
	private JTextField endHour;
	private JLabel lblStartHour;
	private JLabel lblEndHour;
	private JLabel lblTitle;
	private JLabel lblLocation;
	private JLabel lblDescription;
	private JLabel lblCreateEvent;
	private JButton cancel;
	private JButton createEventSubmit;
	private JTextField startMinute;
	private JTextField endMinute;
	private JTextField calendarID;
	private JLabel lblCalendarId;
	private JLabel lblStartMinuts;
	private JLabel lblEndMinuts; 
	private JButton deleteAnEvent;
	
	public static final String CREATEEVENTSUBMIT  = "CreateEventSubmit";
	public static final String DELETEEVENTSUBMIT = "DeleteEventSubmit";
	public static final String CANCEL = "cancel";
	
	
	
	public EventPanel(ActionController actionController) {
		setBackground(Color.PINK);
		setLayout(null);
		
		lblCreateEvent = new JLabel("Create Event");
		lblCreateEvent.setBounds(209, 6, 78, 16);
		add(lblCreateEvent);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(148, 71, 32, 16);
		add(lblTitle);
		
		lblLocation = new JLabel("Location:");
		lblLocation.setBounds(132, 99, 61, 16);
		add(lblLocation);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(116, 139, 77, 16);
		add(lblDescription);
		
		lblStartHour = new JLabel("Start Hour:");
		lblStartHour.setBounds(72, 186, 68, 16);
		add(lblStartHour);
		
		lblEndHour = new JLabel("End Hour:");
		lblEndHour.setBounds(72, 214, 62, 16);
		add(lblEndHour);
		
		createEventSubmit = new JButton("Create");
		createEventSubmit.setBounds(6, 251, 117, 29);
		createEventSubmit.addActionListener(actionController);
		createEventSubmit.setActionCommand(CREATEEVENTSUBMIT);
		add(createEventSubmit);
		
		
		cancel = new JButton("Cancel");
		cancel.setBounds(313, 251, 117, 29);
		cancel.addActionListener(actionController);
		cancel.setActionCommand(CANCEL);
		add(cancel);
		
		title = new JTextField();
		title.setBounds(217, 66, 134, 28);
		title.setColumns(10);
		add(title);
		
		locationField = new JTextField();
		locationField.setBounds(217, 93, 134, 28);
		locationField.setColumns(10);
		add(locationField);
		
		description = new JTextField();
		description.setBounds(217, 133, 134, 28);
		description.setColumns(10);
		add(description);
		
		startHour = new JTextField();
		startHour.setBounds(148, 180, 78, 28);
		startHour.setColumns(10);
		add(startHour);
		
		
		endHour = new JTextField();
		endHour.setBounds(146, 214, 80, 28);
		endHour.setColumns(10);
		add(endHour);
		
		startMinute = new JTextField();
		startMinute.setBounds(339, 180, 91, 28);
		add(startMinute);
		startMinute.setColumns(10);
		
		lblStartMinuts = new JLabel("start minuts:");
		lblStartMinuts.setBounds(260, 186, 81, 16);
		add(lblStartMinuts);
		
		lblEndMinuts = new JLabel("end minuts:");
		lblEndMinuts.setBounds(260, 214, 81, 16);
		add(lblEndMinuts);
		
		endMinute = new JTextField();
		endMinute.setColumns(10);
		endMinute.setBounds(339, 208, 91, 28);
		add(endMinute);
		
		calendarID = new JTextField();
		calendarID.setBounds(219, 36, 134, 28);
		add(calendarID);
		calendarID.setColumns(10);
		
		lblCalendarId = new JLabel("Calendar ID:");
		lblCalendarId.setBounds(103, 42, 77, 16);
		add(lblCalendarId);
		
		deleteAnEvent = new JButton("Delete an Event");
		deleteAnEvent.setBounds(132, 251, 141, 29);
		deleteAnEvent.addActionListener(actionController);
		deleteAnEvent.setActionCommand(DELETEEVENTSUBMIT);
		add(deleteAnEvent);
	
	}
	public void clearFields(){
		
		calendarID.setText("");
		title.setText("");
		description.setText("");
		locationField.setText("");
		startHour.setText("");
		startMinute.setText("");
		endHour.setText("");
		endMinute.setText("");
			
	}
	
	
	public JTextField getTitle() {
		return title;
	}
	public void setTitle(JTextField title) {
		this.title = title;
	}
	public JTextField getLocationField() {
		return locationField;
	}
	public void setLocationField(JTextField locationField) {
		this.locationField = locationField;
	}
	public JTextField getDescription() {
		return description;
	}
	public void setDescription(JTextField description) {
		this.description = description;
	}
	public JTextField getStartHour(){
		return startHour;
	}
	public void setStartHour(JTextField startHour) {
		this.startHour = startHour;
	}
	public JTextField getEndHour(){
		return endHour;
	}
	public void setEndHour(JTextField endHour) {
		this.endHour = endHour;
	}

	public JTextField getStartMinuts() {
		return startMinute;
	}

	public void setStartMinuts(JTextField startMinuts) {
		this.startMinute = startMinuts;
	}

	public JTextField getEndMinuts() {
		return endMinute;
	}

	public void setEndMinuts(JTextField endMinuts) {
		this.endMinute = endMinuts;
	}

	public JTextField getCalendarID() {
		return calendarID;
	}

	public void setCalendarID(JTextField calendarID) {
		calendarID = calendarID;
	}
	
	
	
	
}
