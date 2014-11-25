import javax.swing.JFrame;
import gui._Screen;

public class MainTest {

 /**
  * Starts the program by creating an object of _Screen 
  */
  public static void main(String[] args) {
	  
	  _Screen screen = new _Screen();
	  screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  screen.setVisible(true);
  		}//end main
  
}//end MainTest
