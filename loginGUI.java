import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class loginGUI extends JFrame{
	JLabel jlabel;
	JButton s;
	//====================================Login/Sign up
	public loginGUI(String name) {
		this.setMinimumSize(new Dimension(700,500));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		jlabel = new JLabel(name);
		jlabel.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
		this.add(jlabel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sky Rocket");
		this.pack();
		this.setVisible(true);
	}
}
