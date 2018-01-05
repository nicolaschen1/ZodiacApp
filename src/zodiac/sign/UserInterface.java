/***
 * Author: Nicolas Chen
 * ZodiacApp
 * Version 1.0
***/

package zodiac.sign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UserInterface extends JFrame {
	private ZodiacInfo zodiacInfo = new ZodiacInfo();
	private JLabel nameLabel, firstnameLabel, genderLabel, dayLabel, monthLabel, yearLabel;
	private JComboBox gender;
	private JTextField name, firstname, day, month, year;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("File");
	private JMenuItem item1 = new JMenuItem("About");
	private JMenuItem item2 = new JMenuItem("Close");

	  public UserInterface(){
		ImageIcon img = new ImageIcon("images/icon.png");
		this.setIconImage(img.getImage());
		this.setSize(550, 300);
		this.setTitle("Astrological Sign");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		this.menu1.add(item1);
		this.menu1.add(item2);

		item1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  ZodiacInfo zAbout = new ZodiacInfo();
		    	  JOptionPane jop = new JOptionPane();
				    jop.showMessageDialog(null, zAbout.about(), "About", JOptionPane.INFORMATION_MESSAGE);
				    setVisible(true);
		      }
		    });

		item2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        System.exit(0);
		      }
		    });

		this.menuBar.add(menu1);
		this.setJMenuBar(menuBar);
		this.initComponent();
	}

	public ZodiacInfo showZodiac(){
		this.setVisible(true);
		return this.zodiacInfo;
	}

	private void initComponent(){
		//Lastname
		JPanel panLastname = new JPanel();
		panLastname.setBackground(Color.white);
		panLastname.setPreferredSize(new Dimension(220, 60));
		name = new JTextField();
		name.setPreferredSize(new Dimension(100, 25));
		panLastname.setBorder(BorderFactory.createTitledBorder("Name"));
		nameLabel = new JLabel("Your Name:");
		panLastname.add(nameLabel);
		panLastname.add(name);

		//Firstname
		JPanel panFirstname = new JPanel();
		panFirstname.setBackground(Color.white);
		panFirstname.setPreferredSize(new Dimension(220, 60));
		firstname = new JTextField();
		firstname.setPreferredSize(new Dimension(100, 25));
		panFirstname.setBorder(BorderFactory.createTitledBorder("Firstname"));
		firstnameLabel = new JLabel("Your Firstname:");
		panFirstname.add(firstnameLabel);
		panFirstname.add(firstname);

		//Gender
		JPanel panGender = new JPanel();
		panGender.setBackground(Color.white);
		panGender.setPreferredSize(new Dimension(220, 60));
		panGender.setBorder(BorderFactory.createTitledBorder("Gender"));
		gender = new JComboBox();
		gender.addItem("Male");
		gender.addItem("Female");
		genderLabel = new JLabel("Gender: ");
		panGender.add(genderLabel);
		panGender.add(gender);

		//Birthdate
		JPanel panBirthdate = new JPanel();
		panBirthdate.setBackground(Color.white);
		panBirthdate.setBorder(BorderFactory.createTitledBorder("Birthdate (DD/MM/YYYY)"));
		panBirthdate.setPreferredSize(new Dimension(440, 60));

		//Day
		day = new JTextField();
		day.setPreferredSize(new Dimension(100, 25));
		//panBirthdate.setBorder(BorderFactory.createTitledBorder("Day"));
		dayLabel = new JLabel("Day:");
		panBirthdate.add(dayLabel);
		panBirthdate.add(day);

		//Month
		month = new JTextField();
		month.setPreferredSize(new Dimension(100, 25));
		//panBirthdate.setBorder(BorderFactory.createTitledBorder("Month"));
		monthLabel = new JLabel("Month:");
		panBirthdate.add(monthLabel);
		panBirthdate.add(month);

		//Year
		year = new JTextField();
		year.setPreferredSize(new Dimension(100, 25));
		//panBirthdate.setBorder(BorderFactory.createTitledBorder("Year"));
		yearLabel = new JLabel("Year:");
		panBirthdate.add(yearLabel);
		panBirthdate.add(year);


		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panLastname);
		content.add(panFirstname);
		content.add(panGender);
		content.add(panBirthdate);

		JPanel control = new JPanel();
		JButton okButton = new JButton("Submit");

		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> zodiacSigns = new ArrayList<String>();
				ZodiacSign zodiac = new ZodiacSign();
				int day1, month1, year1;

				try {
					day1 = Integer.parseInt(day.getText());
					month1 = Integer.parseInt(month.getText());
					year1 = Integer.parseInt(year.getText());
					zodiacSigns = zodiac.getZodiac(day1, month1, year1);

					if (!(zodiacSigns.isEmpty() )) {
						zodiacInfo = new ZodiacInfo(name.getText(), firstname.getText(), (String)gender.getSelectedItem(), zodiacSigns.get(0), zodiacSigns.get(1), zodiacSigns.get(2));
						setVisible(false);
						JOptionPane jop = new JOptionPane();
					    jop.showMessageDialog(null, zodiacInfo.toString(), "Astrological sign", JOptionPane.INFORMATION_MESSAGE);
					    setVisible(true);
					}
					else {
						JOptionPane jop = new JOptionPane();
					    jop.showMessageDialog(null, zodiacInfo.error(), "Error Message", JOptionPane.INFORMATION_MESSAGE);
					    setVisible(true);
					}
				} catch (Exception ex) {
					JOptionPane jop = new JOptionPane();
				    jop.showMessageDialog(null, zodiacInfo.error(), "Error Message", JOptionPane.INFORMATION_MESSAGE);
				    setVisible(true);
				}
			}
		});

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okButton);
		control.add(closeButton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}