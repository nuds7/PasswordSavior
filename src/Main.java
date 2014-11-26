import java.io.IOException;

import javax.swing.*;

public class Main {
	public static void main(String[] args) throws IOException{
		JFrame frame = new JFrame ("Password Savior");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	
		JTabbedPane tp = new JTabbedPane();
		PasswordPanel pwdPanel = new PasswordPanel();
		GeneratorPanel genPanel = new GeneratorPanel(pwdPanel);
		
		tp.addTab ("Passwords", pwdPanel);
		tp.addTab ("Generator", genPanel);
		
		frame.getContentPane().add(tp);
		frame.pack();
		
		frame.setSize(640,360);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo( null );
	}
}
