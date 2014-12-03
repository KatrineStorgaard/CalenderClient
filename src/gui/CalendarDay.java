package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import shared.ServerConnection;
import logic.ActionController;

public class CalendarDay extends JPanel {
	
	private ActionController actionController;
	private JLabel title;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private JButton Forecast;
	private JButton showNote;
	private JButton setNote;
	private JTextField noteField;
	public static final String BACK = "Back";
	public static final String FORECAST = "foreCast"; 
	public static final String SHOWNOTE = "note";
	public static final String SETNOTE = "setNote";
	
	public CalendarDay (ActionController actionController){
		setBackground(Color.PINK);
		
		this.actionController = actionController;
		ServerConnection sc = new ServerConnection();
		
		setLayout(null);
		
		title = new JLabel("Label");
		title.setBounds(168, 11, 139, 16);
		add(title);
		
		back = new JButton("Back");
		back.setBounds(168, 150, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
		
		Forecast = new JButton("Forecast");
		Forecast.setBounds(440, 94, 117, 29);
		Forecast.addActionListener(actionController);
		Forecast.setActionCommand(FORECAST);
		add(Forecast);
		
		showNote = new JButton("Note");
		showNote.setBounds(440, 135, 117, 29);
		showNote.addActionListener(actionController);
		showNote.setActionCommand(SHOWNOTE);
		add(showNote);
		
		setNote = new JButton("Set Note");
		setNote.setBounds(626, 23, 105, 29);
		setNote.addActionListener(actionController);
		setNote.setActionCommand(SETNOTE);
		setNote.setVisible(false);
		add(setNote);
		
		noteField = new JTextField();
		noteField.setBounds(50, 50, 400, 100);
		noteField.setVisible(false);
		add(noteField);
		
	}
	
	public void removeNotefield(){
		this.remove(noteField);
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
		 scrollPane.setBounds(26, 30, 398, 120);
		 add(scrollPane);	
	}
	
	public void removeTable(){
		this.remove(resultTable);
		this.remove(scrollPane);
	}
	
	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getResultTable() {
		return resultTable;
	}

	public void setResultTable(JTable resultTable) {
		this.resultTable = resultTable;
	}
	public JButton getShowNote() {
		return showNote;
	}

	public void setShowNote(JButton btnshowNote) {
		this.showNote = showNote;
	}
	public JTextField getNoteField(){
		return noteField;
	}
	public void setNoteField(JTextField noteField){
		this.noteField = noteField;
	}
	public JButton getSetNote(){
		return setNote;
	}
	public void setSetNote(JButton setNote){
		this.setNote = setNote;
	}
}
