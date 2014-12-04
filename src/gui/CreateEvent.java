package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import logic.ActionController;

public class CreateEvent extends JPanel{
	private JTextField title;
	private JTextField location;
	private JTextField description;
	private JTextField start;
	private JTextField end;
	private JLabel lblStart;
	private JLabel lblEnd;
	private JLabel lblTitle;
	private JLabel lblLocation;
	private JLabel lblDescription;
	private JButton cancel;
	private JButton createEventSubmit;
	
	public static final String CREATEEVENTSUBMIT  = "Create";
	public static final String CANCEL = "cancel";
	
	public CreateEvent(ActionController actionController) {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblCreateEvent = new JLabel("Create Event");
		lblCreateEvent.setBounds(186, 25, 78, 16);
		add(lblCreateEvent);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(161, 59, 32, 16);
		add(lblTitle);
		
		lblLocation = new JLabel("Location:");
		lblLocation.setBounds(132, 99, 61, 16);
		add(lblLocation);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(116, 139, 77, 16);
		add(lblDescription);
		
		lblStart = new JLabel("Start");
		lblStart.setBounds(6, 186, 29, 16);
		add(lblStart);
		
		lblEnd = new JLabel("End");
		lblEnd.setBounds(225, 186, 28, 16);
		add(lblEnd);
		
		createEventSubmit = new JButton("Create");
		createEventSubmit.setBounds(76, 214, 117, 29);
		createEventSubmit.setActionCommand(CREATEEVENTSUBMIT);
		add(createEventSubmit);
		
		
		cancel = new JButton("Cancel");
		cancel.setBounds(313, 214, 117, 29);
		cancel.setActionCommand(CANCEL);
		add(cancel);
		
		title = new JTextField();
		title.setBounds(217, 53, 134, 28);
		title.setColumns(10);
		add(title);
		
		location = new JTextField();
		location.setBounds(217, 93, 134, 28);
		location.setColumns(10);
		add(location);
		
		description = new JTextField();
		description.setBounds(217, 133, 134, 28);
		description.setColumns(10);
		add(description);
		
		start = new JTextField();
		start.setText("yyyy-mm-dd hh:mm:ss.sss");
		start.setBounds(35, 180, 191, 28);
		start.setColumns(10);
		add(start);
		
		
		end = new JTextField();
		end.setText("yyyy-mm-dd hh:mm:ss.sss");
		end.setBounds(253, 180, 191, 28);
		end.setColumns(10);
		add(end);
	
	}
	
	public JTextField getTitle() {
		return title;
	}
	public void setTitle(JTextField title) {
		this.title = title;
	}
	public JTextField getaLocation() {
		return location;
	}
	public void setLocation(JTextField location) {
		this.location = location;
	}
	public JTextField getDescription() {
		return description;
	}
	public void setDescription(JTextField description) {
		this.description = description;
	}
	public JTextField getStart(){
		return start;
	}
	public void setStart(JTextField Start) {
		this.start = Start;
	}
	public JTextField getEnd(){
		return end;
	}
	public void setEnd(JTextField end) {
		this.end = end;
	}
	
	
}
