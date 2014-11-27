package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.ActionController;
import javax.swing.JTextPane;

public class CreateNote extends JPanel {
//	private JTextField textLocation;
//	private JTextField textDescription;
//	private JTextField textStart;
//	private JTextField textEnd;
	private JTextPane textText;
	
	public static final String CREATENOTESUBMIT  = "createNoteSubmit";
	
	public CreateNote(ActionController actionController) {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblCreateNote = new JLabel("Create Note");
		lblCreateNote.setBounds(186, 25, 78, 16);
		add(lblCreateNote);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCreate.setBounds(76, 241, 117, 29);
		add(btnCreate);
		btnCreate.setActionCommand(CREATENOTESUBMIT);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(275, 241, 117, 29);
		add(btnCancel);
		
//		textLocation = new JTextField();
//		textLocation.setBounds(217, 93, 134, 28);
//		add(textLocation);
//		textLocation.setColumns(10);
//		
//		textDescription = new JTextField();
//		textDescription.setBounds(217, 133, 134, 28);
//		add(textDescription);
//		textDescription.setColumns(10);
		
		JLabel lblText = new JLabel("Text:");
		lblText.setBounds(66, 82, 32, 16);
		add(lblText);
		
		JTextPane textText = new JTextPane();
		textText.setBounds(126, 81, 198, 138);
		add(textText);
		
//		JLabel lblLocation = new JLabel("Location:");
//		lblLocation.setBounds(132, 99, 61, 16);
//		add(lblLocation);
//		
//		JLabel lblDescription = new JLabel("Description:");
//		lblDescription.setBounds(116, 139, 77, 16);
//		add(lblDescription);
//		
//		textStart = new JTextField();
//		textStart.setBounds(170, 180, 54, 28);
//		add(textStart);
//		textStart.setColumns(10);
//		
//		textEnd = new JTextField();
//		textEnd.setBounds(290, 180, 61, 28);
//		add(textEnd);
//		textEnd.setColumns(10);
//		
//		JLabel lblStart = new JLabel("Start");
//		lblStart.setBounds(124, 186, 29, 16);
//		add(lblStart);
//		
//		JLabel lblEnd = new JLabel("End");
//		lblEnd.setBounds(250, 186, 28, 16);
//		add(lblEnd);
	}
	public JTextPane getText(){
		return  getText();	
	}
}