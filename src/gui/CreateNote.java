package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.ActionController;
import javax.swing.JTextPane;

public class CreateNote extends JPanel {
	
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
		
		JLabel lblText = new JLabel("Text:");
		lblText.setBounds(66, 82, 32, 16);
		add(lblText);
		
		JTextPane textText = new JTextPane();
		textText.setBounds(126, 81, 198, 138);
		add(textText);
	}
	public JTextPane getText(){
		return  getText();	
	}
}