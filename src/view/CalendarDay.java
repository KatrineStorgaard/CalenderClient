package view;

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
	
	private JLabel title;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private JButton Forecast;
	private JButton showNote;
	private JTextField noteField;
	private JButton createEvent;
	private JLabel noteLbl;
	private JButton updateNote;
	private JButton setNote;	
	private JButton deleteNote;
	
	public static final String BACK = "back";
	public static final String FORECAST = "foreCast"; 
	public static final String SHOWNOTE = "showNote";
	public static final String CREATEEVENT = "createEvent";
	public static final String SETNOTE = "setNote";
	public static final String UPDATENOTE = "updateNote";
	public static final String DELETENOTE = "deleteNote";
	
	
	ServerConnection sc = new ServerConnection();
	
	public CalendarDay (ActionController actionController){
		setBackground(Color.PINK);
		
		
		setLayout(null);
		
		title = new JLabel("title");
		title.setBounds(168, 6, 139, 16);
		add(title);
		
		back = new JButton("Back");
		back.setBounds(168, 176, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
			
		Forecast = new JButton("Forecast");
		Forecast.setBounds(440, 57, 117, 29);
		Forecast.addActionListener(actionController);
		Forecast.setActionCommand(FORECAST);
		add(Forecast);
		
		showNote = new JButton("Show Note");
		showNote.setBounds(440, 113, 117, 29);
		showNote.addActionListener(actionController);
		showNote.setActionCommand(SHOWNOTE);
		add(showNote);
		
		noteField = new JTextField();
		noteField.setBounds(28, 70, 400, 74);
		noteField.setVisible(false);
		add(noteField);
		
		createEvent = new JButton("Create a event");
		createEvent.setBounds(440, 79, 117, 29);
		createEvent.addActionListener(actionController);
		createEvent.setActionCommand(CREATEEVENT);
		add(createEvent);
		
		noteLbl = new JLabel();
		noteLbl.setBounds(28, 62, 400, 16);
		add(noteLbl);
		
//		updateNote = new JButton("Update note");
//		updateNote.setBounds(145, 150, 117, 29);
//		updateNote.addActionListener(actionController);
//		updateNote.setActionCommand(UPDATENOTE);
//		updateNote.setVisible(false);
//		add(updateNote);
		
		setNote = new JButton("Set Note");
		setNote.setBounds(440, 138, 117, 29);
		setNote.addActionListener(actionController);
		setNote.setActionCommand(SETNOTE);
		setNote.setVisible(false);
		add(setNote);
		
		deleteNote = new JButton("Delete note");
		deleteNote.setBounds(440, 164, 117, 29);
		deleteNote.addActionListener(actionController);
		deleteNote.setActionCommand(DELETENOTE);
		add(deleteNote);
		
	}
	
	public void removeNotefield(){
		this.remove(noteField);
	}
	
	public void removeNoteLbl(){
		this.remove(noteLbl);
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
		if(resultTable!=null){
			this.remove(resultTable);
			this.remove(scrollPane);
			}
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

	public void setShowNote(JButton showNote) {
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
	public JButton getCreateEvent(){
		return createEvent;
	}
	public void setCreateEvent(JButton createEvent){
		this.createEvent = createEvent;
	}

	public JLabel getNoteLbl() {
		return noteLbl;
	}

	public void setNoteLbl(JLabel noteLbl) {
		this.noteLbl = noteLbl;
	}

	public JButton getUpdateNote() {
		return updateNote;
	}

	public void setUpdateNote(JButton updateNote) {
		this.updateNote = updateNote;
	}
}
