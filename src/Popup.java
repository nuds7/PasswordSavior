import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Popup {
	JTextField webField = new JTextField(21);
	JTextField userField = new JTextField(21);
	JTextField passField = new JTextField(21);
	JButton savePassword = new JButton ("Save");
	
	public Popup(final PasswordPanel hostPanel, String currPass) throws IOException{
		final JDialog frame = new JDialog ();
		frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		webField.setText("www.exampleweb.com");
		webField.setHorizontalAlignment(JTextField.CENTER);
		userField.setText("User Name");
		userField.setHorizontalAlignment(JTextField.CENTER);
		passField.setText(currPass);
		passField.setHorizontalAlignment(JTextField.CENTER);
		
		frame.getContentPane().add(webField);
		frame.getContentPane().add(userField);
		frame.getContentPane().add(passField);
		frame.getContentPane().add(savePassword);
		frame.pack();
		
		frame.setSize(200,140);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo( null );
		
		frame.setAlwaysOnTop(true); // keeps the window at the front so the user doesn't lose it
		
		savePassword.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	// save what's in the text fields
		    	new TextFileWriter("passwords.txt", webField.getText(), userField.getText(), passField.getText());
		    	// close the frame upon clicking save
		    	hostPanel.listContainer.removeAll();
		    	
		    	try {
					hostPanel.populateListContainer(hostPanel.listContainer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	hostPanel.listContainer.updateUI();
		    	
		    	frame.dispose();
		    }
		});
	}
}
