package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.ActionController;

//import logic.Appointment;
//import logic.KalData;
//import logic.Note;

public class CalendarWeek extends JPanel {
	
	private static int START_WEEK = 15;	// Default month when application starts
	private static int START_YEAR = 2003;	// Default year when application starts

///// Const related to calendar
	private static String MONTHDAYSEPARATOR =" ";
	private static String days[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	private static String months[] = {"January", "February", "March",
	"April", "May", "June", "July", "August", 
	"September","October", "November", "December"};
	private static String shortmonths[] = {"Jan", "Feb", "Mar",
	"Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec"};
	private static int DaysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int FEBRUARY = 1;
	
///// UI Components
private static JTextField weekTextField;
private static JTextField yearTextField;
private static JPanel paneDate, paneTop;
private static JPanel paneCal ;
private static JPanel  paneCalHeader ;
private static JButton bnDay[];
private ActionController actionController;

///// Global Variables
int  iLastUserWeek = 0 , iLastUserYear = 0 ;



public CalendarWeek (ActionController actioncontroller, JPanel paneView)
{
	
this.actionController = actionController;

Calendar cal = new GregorianCalendar();
cal = Calendar.getInstance();
START_WEEK = cal.get(Calendar.WEEK_OF_YEAR);
START_YEAR = cal.get(Calendar.YEAR);
weekTextField = new JTextField(""+ START_WEEK, 3);
yearTextField = new JTextField(""+ START_YEAR, 5);

//DATE panel //////////

//paneDate = new JPanel();
ImageIcon icoArrow = new ImageIcon("Arrow.gif", "Show Calendar");
JButton bnArrow =new JButton("Go",icoArrow); 
bnArrow.setBackground(new Color(0x00, 0x99, 0xCC));
bnArrow.addActionListener(actionController); 
bnArrow.setBorder(BorderFactory.createRaisedBevelBorder());

paneDate.setBorder(BorderFactory.createEmptyBorder(1,1,1,1  )  );
paneDate.setBackground(new Color(0x5F,0x9E,0xA0));
paneDate.setLayout(new  FlowLayout());
paneDate.add(weekTextField,BorderLayout.WEST);
paneDate.add(yearTextField , BorderLayout.CENTER);	
paneDate.add(bnArrow, BorderLayout.EAST);

paneCalHeader = new JPanel();
paneCalHeader.setLayout(new FlowLayout());
paneCalHeader.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1) );
paneCalHeader.setBorder(BorderFactory.createLoweredBevelBorder() );
paneCalHeader.setBackground(java.awt.Color.yellow);

paneTop = new JPanel();
paneTop.setLayout(new FlowLayout());
paneTop.setBackground(new Color(0x5F,0x9E,0xA0));
paneTop.add(paneDate, BorderLayout.NORTH);
paneTop.add(paneCalHeader, BorderLayout.NORTH);

//  CALENDAR panel /////////
paneCal = new JPanel();
bnDay = new JButton[31];
paneCal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10) );
paneCal.setBorder(BorderFactory.createLoweredBevelBorder() );
paneCal.setLayout(new GridLayout(0, 7));

paneView.setLayout(new BorderLayout());
paneView.add(paneTop, BorderLayout.NORTH);
paneView.add(paneCal, BorderLayout.CENTER);

buildView(START_WEEK , START_YEAR);
return;

	}
private boolean drawCalendarHeader(JPanel pane, 
int iUserWeek, int iUserYear)
{
JLabel lbl;
try{

pane.removeAll();
lbl = new JLabel(" WEEK:" + iUserWeek);
lbl.setHorizontalAlignment(JLabel.CENTER);
pane.add(lbl);

lbl = new JLabel("YEAR:" + iUserYear +" ");
lbl.setHorizontalAlignment(JLabel.CENTER);
pane.add(lbl);

iLastUserWeek =  iUserWeek;
iLastUserYear = iUserYear;

}catch(Exception ex){ ex.printStackTrace();}

pane.repaint();
return true;

}

private boolean drawWeekHeader(JPanel pane)
{
JLabel lbl;
try{
// Draw the Weekday header
lbl = new JLabel(days[0]);
lbl.setForeground(java.awt.Color.blue);
lbl.setHorizontalAlignment(JLabel.CENTER);
lbl.setBackground(Color.white);
lbl.setOpaque(true);
lbl.setSize(new Dimension(25,25));

pane.add(lbl);
for (int i = 1; i< 6; i++)
{	lbl = new JLabel(days[i]);
lbl.setHorizontalAlignment(JLabel.CENTER);
lbl.setOpaque(true);
lbl.setBackground(java.awt.Color.white);
lbl.setSize(new Dimension(25,25));
pane.add(lbl);
} 
lbl = new JLabel(days[6]);
lbl.setForeground(java.awt.Color.blue);
lbl.setHorizontalAlignment(JLabel.CENTER);
lbl.setBackground(Color.white);
lbl.setOpaque(true);
lbl.setSize(new Dimension(25,25));
pane.add(lbl);

}catch(Exception ex){ ex.printStackTrace();}

pane.repaint();
return true;
}
private boolean drawCalendar(JPanel pane, JButton[] bnDay, int userWeek, int userYear )
{
try{
Calendar cal = new GregorianCalendar();
START_WEEK = cal.get(Calendar.WEEK_OF_YEAR);
cal = Calendar.getInstance();
JLabel lblTmp[];
int iMonth, iDay;
pane.removeAll();
drawWeekHeader(pane);

// Draw the days
cal.setFirstDayOfWeek(Calendar.SUNDAY);
cal.set(Calendar.WEEK_OF_YEAR, userWeek);
cal.set(Calendar.YEAR, userYear);

int weekday = cal.get(Calendar.DAY_OF_WEEK);
cal.add(Calendar.DATE,1 - weekday);
for (int i = 0; i <  7 ; i++){
iMonth =  cal.get(Calendar.MONTH);
iDay = cal.get(Calendar.DAY_OF_MONTH);
/*
if ((iDay+i) > DaysInMonth[iMonth]){
//iDay = iDay - DaysInMonth[iMonth];
iMonth ++;
if (iMonth > 11) iMonth = 0 ;
}
*/
//bnDay[i] = new JButton("" + (iMonth + 1) + MONTHDAYSEPARATOR + (iDay+i) );
switch(iMonth){
case 0:bnDay[i] = new JButton("Jan" + MONTHDAYSEPARATOR + (iDay) );break;
case 1:bnDay[i] = new JButton("Feb" + MONTHDAYSEPARATOR + (iDay) );break;
case 2:bnDay[i] = new JButton("Mar" + MONTHDAYSEPARATOR + (iDay) );break;
case 3:bnDay[i] = new JButton("Apr" + MONTHDAYSEPARATOR + (iDay) );break;
case 4:bnDay[i] = new JButton("May" + MONTHDAYSEPARATOR + (iDay) );break;
case 5:bnDay[i] = new JButton("Jun" + MONTHDAYSEPARATOR + (iDay) );break;
case 6:bnDay[i] = new JButton("Jul" + MONTHDAYSEPARATOR + (iDay) );break;
case 7:bnDay[i] = new JButton("Aug" + MONTHDAYSEPARATOR + (iDay) );break;
case 8:bnDay[i] = new JButton("Sep" + MONTHDAYSEPARATOR + (iDay) );break;
case 9:bnDay[i] = new JButton("Oct" + MONTHDAYSEPARATOR + (iDay) );break;
case 10:bnDay[i] = new JButton("Nov" + MONTHDAYSEPARATOR + (iDay) );break;
case 11:bnDay[i] = new JButton("Dec" + MONTHDAYSEPARATOR + (iDay) );break;
}
Insets ins = new Insets(0,0,25,25);	    
bnDay[i].setMargin(ins);
bnDay[i].addActionListener(actionController); 

//if  (m_dta.hasApptVector(userYear , iMonth , iDay - 1) || m_dta.hasNoteVector(userYear, iMonth, iDay - 1)){
////bnDay[i].setBackground(java.awt.Color.red);
//if((PraktiKal.currentOwner).equals("All")){
//bnDay[i].setBackground(Color.red);
//bnDay[i].setOpaque(true);
//}else{
//Vector apptV = m_dta.getApptVector(userYear, iMonth, iDay - 1);
//Vector noteV = m_dta.getNoteVector(userYear, iMonth, iDay - 1);
//boolean colored = false;
////if(apptV != null ){
////Appointment a;
////for(int q = 0; (q < apptV.size()) && !colored; q++){
////a = (Appointment) apptV.elementAt(q);
////if((a.getOwner()).equals(PraktiKal.currentOwner)){
////bnDay[i].setBackground(Color.red);
////bnDay[i].setOpaque(true);
////colored = true;
////
////}
////}
////}
////if(!colored && noteV != null){
////Note n;
////for(int q = 0; (q < noteV.size()) && !colored; q++){
////n = (Note) noteV.elementAt(q);
////if((n.getOwner()).equals(PraktiKal.currentOwner)){
////bnDay[i].setBackground(Color.red);
////bnDay[i].setOpaque(true);
////colored = true;
////
////}
////}
////}
//}
//
//}		    
pane.add(bnDay[i], BorderLayout.NORTH);
cal.add(Calendar.DATE, 1);

}
//pane.repaint();
}	
catch(Exception ex)
{
ex.printStackTrace();
return false;
}
pane.repaint();
return true;
}

private boolean IsLeapYear(int year)
{
if ((year % 100) == 0) return((year % 400) == 0);
return ((year % 4) == 0);
} 

private boolean buildView(int week, int year)
{

drawCalendar(paneCal, bnDay, week ,year	 );
drawCalendarHeader(paneCalHeader,week, year);


return true;
}


public void actionPerformed(ActionEvent e) 
{

//Go Clicked
if (e.getActionCommand() == "Go")
{	
buildView(Integer.parseInt(weekTextField.getText()), Integer.parseInt(yearTextField.getText()) );
}
else
{
//Date Clicked
int iMonth, iDay, iMid;
String sMonthDay = e.getActionCommand();
iMid = sMonthDay.indexOf(MONTHDAYSEPARATOR);
String monthString = sMonthDay.substring(0,iMid);
iMonth = 0;
if(monthString.equals("Jan")){
iMonth = 0;
}else if(monthString.equals("Feb")){
iMonth = 1;
}else if(monthString.equals("Mar")){
iMonth = 2;
}else if(monthString.equals("Apr")){
iMonth = 3;
}else if(monthString.equals("May")){
iMonth = 4;
}else if(monthString.equals("Jun")){
iMonth = 5;
}else if(monthString.equals("Jul")){
iMonth = 6;
}else if(monthString.equals("Aug")){
iMonth = 7;
}else if(monthString.equals("Sep")){
iMonth = 8;
}else if(monthString.equals("Oct")){
iMonth = 9;
}else if(monthString.equals("Nov")){
iMonth = 10;
}else if(monthString.equals("Dec")){
iMonth = 11;
}


//iDay = Integer.parseInt(sMonthDay.substring(iMid+1, sMonthDay.length()));
//
//DayView viewDay = new DayView(m_frame, m_dta, iLastUserYear, iMonth, iDay - 1);
//buildView(Integer.parseInt(weekTextField.getText()), Integer.parseInt(yearTextField.getText()) );
}
//m_frame.pack();
//m_frame.setVisible(true);

return;

}

}





