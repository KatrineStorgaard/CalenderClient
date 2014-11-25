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
	private JTextField textTitle;
	private JTextField textLocation;
	private JTextField textDescription;
	private JTextField textStart;
	private JTextField textStop;
	
	public static final String CREATEEVENTSUBMIT  = "createEventSubmit";
	
	public CreateEvent(ActionController actionController) {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblCreateEvent = new JLabel("Create Event");
		lblCreateEvent.setBounds(186, 25, 78, 16);
		add(lblCreateEvent);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCreate.setBounds(76, 241, 117, 29);
		add(btnCreate);
		btnCreate.setActionCommand(CREATEEVENTSUBMIT);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(275, 241, 117, 29);
		add(btnCancel);
		
		textTitle = new JTextField();
		textTitle.setBounds(217, 53, 134, 28);
		add(textTitle);
		textTitle.setColumns(10);
		
		textLocation = new JTextField();
		textLocation.setBounds(217, 93, 134, 28);
		add(textLocation);
		textLocation.setColumns(10);
		
		textDescription = new JTextField();
		textDescription.setBounds(217, 133, 134, 28);
		add(textDescription);
		textDescription.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(161, 59, 32, 16);
		add(lblTitle);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(132, 99, 61, 16);
		add(lblLocation);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(116, 139, 77, 16);
		add(lblDescription);
		
		textStart = new JTextField();
		textStart.setBounds(170, 180, 54, 28);
		add(textStart);
		textStart.setColumns(10);
		
		textStop = new JTextField();
		textStop.setBounds(290, 180, 61, 28);
		add(textStop);
		textStop.setColumns(10);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(124, 186, 29, 16);
		add(lblStart);
		
		JLabel lblStop = new JLabel("Stop");
		lblStop.setBounds(250, 186, 28, 16);
		add(lblStop);
	}
	public JTextField getTextTitle(){
		return  textTitle;	
	}
	
	public JTextField getTextLocation(){
		return  textLocation;	
	}
	
	public JTextField getTextDecription(){
		return  textDescription;
	}
	public JTextField getTextStart(){
		return  textStart;
	}
	public JTextField getTextStop(){
		return  textStop;
		
	}
}
