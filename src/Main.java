import java.io.IOException;

import javax.swing.*;
public class Main {
	public static void main(String[] args) throws IOException{
		JFrame frame = new JFrame ("Password Savior");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	
		JTabbedPane tp = new JTabbedPane();
		tp.addTab ("Passwords", new PasswordsPanel());
		tp.addTab ("Generator", new PasswordsPanel());
		frame.getContentPane().add(tp);
		frame.pack();
		frame.setVisible(true);
	}
}
