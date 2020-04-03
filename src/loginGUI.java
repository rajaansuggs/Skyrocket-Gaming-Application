import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class loginGUI extends JFrame{
	JLabel jlabel;
	JButton s;
	//====================================Login/Sign up
	public loginGUI(boolean isLoginCapabilities, String name, boolean isLinked) {
		if(isLoginCapabilities == true && isLinked == false) {
			this.setMinimumSize(new Dimension(1500,700));
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			jlabel = new JLabel(name);
			jlabel.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
			this.add(jlabel);	
		}
		else if(isLoginCapabilities == false && isLinked == false){
			this.setMinimumSize(new Dimension(400,400));
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, 0));
			jlabel = new JLabel(name);
			jlabel.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 12));
			this.add(jlabel);
		}
		else {
			this.setMinimumSize(new Dimension(400,400));
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, 0));
			jlabel = new JLabel(name);
			this.add(jlabel);
		}
		this.setTitle("Sky Rocket");
		this.pack();
		this.setVisible(true);	
			
		}
	}

