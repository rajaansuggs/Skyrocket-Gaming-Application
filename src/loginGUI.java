import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class loginGUI extends JFrame implements Serializable{
	private final static String FILENAME = "user.bin";
	private ArrayList<User> users = new ArrayList<User>();
	JLabel jlabel;
	JButton s;
	private UsersCard uc = new UsersCard(FILENAME);
	//====================================Login/Sign up
	public loginGUI(boolean isLoginCapabilities, String name, boolean isLinked) {
		if(isLoginCapabilities == true && isLinked == false) {
			this.setMinimumSize(new Dimension(1500,700));
			this.getContentPane().setLayout(null);
			JButton loginOrSignInButton = new JButton(name);
			loginOrSignInButton.setBounds(80, 200, 100, 20);
			this.getContentPane().add(loginOrSignInButton);
			
			jlabel = new JLabel(name);
			jlabel.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
			this.add(jlabel);
			
			JLabel userName = new JLabel("Username");
			userName.setBounds(55, 135, 100, 20);
			this.getContentPane().add(userName);
			JLabel password = new JLabel("Password");
			password.setBounds(55, 175, 100, 20);
			this.getContentPane().add(password);
			this.getContentPane().add(jlabel);
		
			
			JTextField userNameTextField = new JTextField();
			userNameTextField.setBounds(155, 135, 389, 20);
			this.getContentPane().add(userNameTextField);
			
			JTextField passwordTextField = new JTextField();
			passwordTextField.setBounds(155, 175, 389, 20);
			this.getContentPane().add(passwordTextField);
			
			if(name.equals("Sign up")) {
				JLabel firstName = new JLabel("First Name");
				firstName.setBounds(55, 50, 100, 20);
				this.getContentPane().add(firstName);
				
				JLabel lastName = new JLabel("Last Name");
				lastName.setBounds(55, 95, 100, 20);
				this.getContentPane().add(lastName);
				
				JTextField firstNameTextField = new JTextField();
				firstNameTextField.setBounds(155, 50, 389, 20);
				this.getContentPane().add(firstNameTextField);
				
				JTextField lastNameTextField = new JTextField();
				lastNameTextField.setBounds(155, 95, 389, 20);
				this.getContentPane().add(lastNameTextField);
				//Load a new User
				loginOrSignInButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent m) {
						uc.addUser((int)(Math.random()), firstNameTextField.getText(), lastNameTextField.getText(), userNameTextField.getText(), passwordTextField.getText());
					}
				});
				
				
			}
						
		}
		else if(isLoginCapabilities == false && isLinked == false){
			this.setMinimumSize(new Dimension(800,400));
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, 0));
			jlabel = new JLabel(name);
			jlabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			this.add(jlabel);
		}
		this.setTitle("Sky Rocket");
		this.pack();
		this.setVisible(true);	

	}
	public loginGUI(Game g) {
		this.setMinimumSize(new Dimension(400,400));
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		String s = "Description: "+ g.getGameDescription()+ "    ";
		JLabel descLabel = new JLabel(s);
		String rate = "Rating: " + g.getStarRating() + "/5 Stars    ";
		JLabel rateLabel = new JLabel(rate);
		String url = g.getGameHyperLink();
		JLabel linkLabel = new JLabel(url);
		linkLabel.setForeground(Color.BLUE);
		linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		linkLabel.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                linkLabel.setText("Visit " + g.getGameName());
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                linkLabel.setText("<html><a href=''>Visit "+ g.getGameName() + "</a></html>");
            }
 
		});
		panel.add(descLabel);
		panel.add(rateLabel);
		panel.add(linkLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(panel);
		this.setTitle("Sky Rocket");
		this.pack();
		this.setVisible(true);	
		
	}


}
