import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicalUserInterface{
	private JLabel label;
	private JFrame window;
	private JLabel loginButton, signupButton;
	private Icon loginIcon, signupIcon;
	//====================================GUI constructor
	public GraphicalUserInterface() {
		window = new JFrame("Sky Rocket");
		label = new JLabel("Sky Rocket");
		label.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
		//====================================Sign up
		signupIcon = new ImageIcon(getClass().getResource("/resources/icons8-sign-up-64.png"));
		window.setMinimumSize(new Dimension(700,500));
		signupButton = new JLabel(signupIcon); //Label's use addMouseListeners while JButton's addActionLAISTENER
		signupButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI("Sign up");
				window.dispose();			}
		});
		//====================================Login
		loginIcon = new ImageIcon(getClass().getResource("/resources/icons8-enter-64.png"));
		loginButton = new JLabel(loginIcon); //Label's use addMouseListeners while JButton's addActionLAISTENER
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI("Login");
				window.dispose();
			}
		});
		//panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		window.add(label);
		window.add(signupButton);
		window.add(loginButton);
		window.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Sky Rocket");
		window.pack();
		window.setVisible(true);
		
	}
	
}
