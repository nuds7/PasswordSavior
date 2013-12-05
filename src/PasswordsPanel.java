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

public class PasswordsPanel extends JPanel {
	private String password = "P4S5W0RD";
	private JButton generateButton = new JButton ("Generate!");
	
	public PasswordsPanel() throws IOException{
		
		
		setLayout (new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1,4));
		northPanel.setBorder(new EmptyBorder(5,5,5,5));
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.setBorder(new EmptyBorder(5,5,5,5));
		
		String[] minLength = {"1","2","3","4","5","6","7","8","9",
							  "10","11","12","13","14","15","16",
							  "17","18","19",};
		String[] maxLength = {"1","2","3","4","5","6","7","8","9",
							  "10","11","12","13","14","15","16",
							  "17","18","19","20"};
		
		JComboBox minCombo = new JComboBox(minLength);
		JComboBox maxCombo = new JComboBox(maxLength);
		minCombo.setSelectedIndex(4);
		maxCombo.setSelectedIndex(5);
		
		JLabel minLabel = new JLabel ("Min Length", JLabel.CENTER);
		JLabel maxLabel = new JLabel ("Max Length", JLabel.CENTER);
		northPanel.add(minLabel);
		northPanel.add(minCombo);
		northPanel.add(maxLabel);
		northPanel.add(maxCombo);
		add("North", northPanel);
		
		JTextField textField = new JTextField(20);
		textField.setText(password);
		textField.setEditable(false);
		
		GeneratePassword generator = new GeneratePassword(textField, minCombo, maxCombo);
		generateButton.addActionListener(generator);
		
		southPanel.add("West", generateButton);
		southPanel.add("East", textField);
		add("South", southPanel);
	}
}


class GeneratePassword implements ActionListener{
	private JTextField passwordField;
	private String newPassword;
	
	public GeneratePassword(JTextField field, JComboBox minCombo, JComboBox maxCombo) throws IOException{
		this.passwordField = field;
		BufferedReader in = new BufferedReader(new FileReader(new File("nouns.txt")));

		while (in.ready()) {
		  String s = in.readLine();
		}
		in.close();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		passwordField.setText(newPassword);
	}
}