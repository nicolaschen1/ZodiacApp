/***
 * Author: Nicolas Chen
 * ZodiacApp
 * Version 1.0
***/

package zodiac.sign;

import javax.swing.JFrame;


public class MainWindow extends JFrame {
  public static void main(String[] main){
	  UserInterface zd = new UserInterface();
      ZodiacInfo zInfo = zd.showZodiac();
  }
}
