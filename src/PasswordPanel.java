import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PasswordPanel extends JPanel {
    public JPanel listContainer = new JPanel();

    public PasswordPanel() throws IOException {
    	//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	setLayout(new BorderLayout());
    	
        //listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
        
        populateListContainer(listContainer);
        
        final JScrollPane scroll = new JScrollPane(listContainer);
        //scroll.setPreferredSize(new Dimension(400,300));
        this.add(scroll, BorderLayout.CENTER);
        scroll.getVerticalScrollBar().setUnitIncrement(12);
        
        JButton button = new JButton("Add Password");
        
        final PasswordPanel thisPanel = this;
        
        button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // new Popup(textField.getText()); // ORIGINAL 
		    	try {
					new Popup(thisPanel, "P4S5W0RD");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});

        this.add(button, BorderLayout.PAGE_END);
    }
    
    public void populateListContainer(JPanel listContainer) throws IOException{
    	
    	TextFileReader passwords = new TextFileReader("passwords.txt");
    	
    	for (final Object p: passwords.splitStringsIntoArray()){
        	
        	final JPanel newPanel = new JPanel();
        	newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.X_AXIS));
        	newPanel.setPreferredSize(new Dimension(300,26));
        	
        	JButton copyButton = new JButton ("Copy Password");
        	JTextField webField = new JTextField(21);
        	JTextField usrField = new JTextField(21);
        	
        	webField.setText((String) ((ArrayList) p).get(0));
        	webField.setEditable(false);
        	usrField.setText((String) ((ArrayList) p).get(1));
        	usrField.setEditable(false);
        	
        	copyButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			StringSelection selection = new StringSelection((String) ((ArrayList) p).get(2));
        			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        			clipboard.setContents(selection, selection);
        			((AbstractButton) e.getSource()).setText("Password Copied");
    		    }
    		});
        	
        	SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    newPanel.scrollRectToVisible(newPanel.getBounds());
                }
                
            });
        	
        	newPanel.add(webField);
        	newPanel.add(usrField);
            newPanel.add(copyButton);
            listContainer.add(newPanel);
            listContainer.revalidate();
        }
    }
}