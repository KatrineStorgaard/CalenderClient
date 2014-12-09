package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.ActionController;
import java.awt.Color;

public class CalendarSettings extends JPanel{
	private JLabel title;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	public static final String BACK = "Back";
	public static final String CREATECAL = "createCal";
	public static final String DELTECAL = "deleteCal";
	public static final String SHARECAL = "shareCal";
	
	
	public CalendarSettings(ActionController actionController){
		setBackground(Color.PINK);
		
		setLayout(null);
		
		title = new JLabel("Titel");
		title.setBounds(244, 6, 28, 16);
		add(title);
		
		back = new JButton("Back");
		back.setBounds(196, 247, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
		JButton createCal = new JButton("Create Calendar");
		createCal.setBounds(739, 59, 143, 29);
		createCal.addActionListener(actionController);
		createCal.setActionCommand(CREATECAL);
		add(createCal);
				
		JButton deleteCal = new JButton("Delete Calendar");
		deleteCal.setBounds(739, 100, 143, 29);
		deleteCal.addActionListener(actionController);
		deleteCal.setActionCommand(DELTECAL);
		add(deleteCal);
		
		JButton shareCal = new JButton("Share Calendar");
		shareCal.setBounds(739, 141, 143, 29);
		shareCal.addActionListener(actionController);
		shareCal.setActionCommand(SHARECAL);
		add(shareCal);
		
	}

	
	
	
	public void removeTable(){
		this.remove(resultTable);
		this.remove(scrollPane);
	}
	
	
	public void addTable(Object[][] data,String[] columnNames){
		
		if(resultTable!=null){
		this.remove(resultTable);
		this.remove(scrollPane);
		}
		 resultTable = new JTable(data, columnNames);
		 resultTable.setPreferredScrollableViewportSize(new Dimension(800,70));
		 resultTable.setFillsViewportHeight(true);
		 
		 scrollPane = new JScrollPane(resultTable);
		 scrollPane.setBounds(30, 30, 600, 200);
		 add(scrollPane);	
	}
}


