package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import logic.ActionController;

public class Login extends JPanel {

	//Declaration of attributes
	private ActionController actionController;
	private JTextField txtremail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblLogin;
	private JLabel lblTop;
	private JLabel lblBackground;
	private JLabel lblBTCLogo;
	private JLabel lblCBSLogo;
	
	// Declaration of panel constants
	public static final String LOGINSUBMIT  = "loginSubmit";
	
	//constructor
	public Login(ActionController actionController){
		setBackground(Color.PINK);
		
		this.actionController = actionController;
		//sets absolutelayout
		setLayout(null);
		//sets the defined size
		setSize(600,242);
		
		lblTop = new JLabel("Calendar");
		lblTop.setBounds(502, 6, 98, 33);
		add(lblTop);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(282, 60, 35, 16);
		add(lblLogin);
		
		txtremail = new JTextField("dafr13ab@student.cbs.dk");
		txtremail.setBounds(175, 111, 250, 29);
		add(txtremail);
		
		txtremail.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(txtremail.getText().equals("Insert your CBS E-mail address"))
				txtremail.setText("");
				
			}
		});
		
		passwordField = new JPasswordField("123456");
		passwordField.setBounds(175, 147, 250, 29);
		add(passwordField);
		
		passwordField.addMouseListener(new MouseListener(){
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(passwordField.getText().equals("Password"))
					passwordField.setText("");
			}
		});
		
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(241, 188, 117, 29);
		add(btnLogin);
		btnLogin.addActionListener(actionController);
		btnLogin.setActionCommand(LOGINSUBMIT);
		
		lblBTCLogo = new JLabel("");
		lblBTCLogo.setBounds(170,278,80,80);
		add(lblBTCLogo);
		
		lblCBSLogo = new JLabel("");
		lblCBSLogo.setBounds(0,0,600,48);
		lblCBSLogo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		add(lblCBSLogo);
		
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 266, 400);
		add(lblBackground);
		
	}//end constructor 

	//return text inserted in Txtremail
	public JTextField getTxtremail() {
		return txtremail;
	}//end method getTextremail

	//return password inserted in PasswordField 
	public JPasswordField getPasswordField() {
		return passwordField;
	}//end method getPasswordField
	
	
	
}
