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
	private JLabel celsius;
	private JLabel date;
	private JLabel desc;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private JButton Forecast;
	private JButton showNote;
	private JButton setNote;
	private JTextField noteField;
	private JButton createEvent;
	public static final String BACK = "back";
	public static final String FORECAST = "foreCast"; 
	public static final String SHOWNOTE = "showNote";
	public static final String CREATEEVENT = "createEvent";
	public static final String SETNOTE = "setNote";
	
	public CalendarDay (ActionController actionController){
		setBackground(Color.PINK);
		
		this.actionController = actionController;
		ServerConnection sc = new ServerConnection();
		
		setLayout(null);
		
		title = new JLabel("title");
		title.setBounds(168, 6, 139, 16);
		add(title);
		
		date = new JLabel ("date");
		date.setBounds(168, 82, 144, 20);
		date.setVisible(false);
		add(date);
	
		
		celsius = new JLabel ("celsius");
		celsius.setBounds(168, 96, 146, 22);
		celsius.setVisible(false);
		add(celsius);
		
		
		desc = new JLabel ("desc");
		desc.setBounds(168, 114, 148, 24);
		desc.setVisible(false);
		add(desc);
		
		
		
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
		showNote.setBounds(440, 82, 117, 29);
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
		noteField.setBounds(28, 57, 400, 100);
		noteField.setVisible(false);
		add(noteField);
		
		createEvent = new JButton("Create a event");
		createEvent.setBounds(440, 113, 117, 29);
		createEvent.addActionListener(actionController);
		createEvent.setActionCommand(CREATEEVENT);
		add(createEvent);
		
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
		 resultTable.setEnabled(false);
		 
		 
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
	public JLabel getCelsius() {
		return title;
	}

	public void setCelsius(JLabel celsius) {
		this.celsius = celsius;
	}
	public JLabel getDesc() {
		return desc;
	}

	public void setDesc(JLabel desc) {
		this.desc = desc;
	}
	public JLabel getDate() {
		return date;
	}

	public void setDate(JLabel date) {
		this.date = date;
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
	public JButton getCreateEvent(){
		return createEvent;
	}
	public void setCreateEvent(JButton createEvent){
		this.createEvent = createEvent;
	}
	
}
