import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GeneratorPanel extends JPanel {
	private String password = "P4S5W0RD";
	private JButton generateButton = new JButton ("Generate!");
	private JButton saveButton = new JButton ("Save!");
	JTextField textField = new JTextField(21);
	
	public GeneratorPanel(final PasswordPanel passPanel) throws IOException{
		
		setLayout (new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1,4));
		northPanel.setBorder(new EmptyBorder(5,5,5,5));
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,5));
		southPanel.setBorder(new EmptyBorder(5,5,5,5));
		
		String[] minLength = {"1","2","3","4","5","6","7","8","9",
							  "10","11","12","13","14","15","16",
							  "17","18","19","20"};
		String[] maxLength = {"1","2","3","4","5","6","7","8","9",
							  "10","11","12","13","14","15","16",
							  "17","18","19","20","21"};
		
		final JComboBox minCombo = new JComboBox(minLength);
		final JComboBox maxCombo = new JComboBox(maxLength);
		minCombo.setSelectedIndex(9);
		maxCombo.setSelectedIndex(11);
		
		JLabel minLabel = new JLabel ("Min Length", JLabel.CENTER);
		JLabel maxLabel = new JLabel ("Max Length", JLabel.CENTER);
		northPanel.add(minLabel);
		northPanel.add(minCombo);
		northPanel.add(maxLabel);
		northPanel.add(maxCombo);
		add("North", northPanel);
		
		textField.setText(password);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		
		final PasswordGenerator pwdGen = new PasswordGenerator();
		
		generateButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String pwd = pwdGen.generatePassword(Integer.parseInt((String) minCombo.getSelectedItem()), 
		        									 Integer.parseInt((String) maxCombo.getSelectedItem()));
		        textField.setText(pwd);
		    }
		});
		
		saveButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // new Popup(textField.getText()); // ORIGINAL 
		    	
		    	try {
					new Popup(passPanel, textField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		southPanel.add(generateButton);
		//southPanel.add(new JLabel(""));
		southPanel.add(textField);
		//southPanel.add(new JLabel(""));
		southPanel.add(saveButton);
		add("South", southPanel);
	}
}


class PasswordGenerator{
	private String characters 	= "abcdefghijklmnopqrstuvwxyz";
	private String numbers 		= "1234567890";
	private String symbols 		= "!@&$%-";
	private RandomGenerator randGen;
	
	public String generatePassword(int minL, int maxL){
		int randMin = randGen.randomInt(minL, maxL);
		String randCharacters = "";
		
		for(int i = 0;i<randMin;i++){
			int a = randGen.randomInt(1,10);
			if (a <= 7){
				String r = getRandChar(characters);
				randCharacters += r;
			} else if (a == 8 || a == 9){
				String r = getRandChar(numbers);
				randCharacters += r;
			} else {
				String r = getRandChar(symbols);
				randCharacters += r;
			}
		}
		
		System.out.println(randCharacters);;
		return randCharacters;
	}
	private String getRandChar(String chars){
		int len = chars.length();
		int a = randGen.randomInt(0,len-1);
		String c = Character.toString(chars.charAt(a));
		if (randGen.randomInt(0,1) == 1){
			c = c.toUpperCase();
		}
		return c;
	}
}