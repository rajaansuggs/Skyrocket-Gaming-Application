import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class loginGUI extends JFrame implements Serializable{
	private static HashSet<User> users = new HashSet<User>();
	JLabel jlabel;
	JButton s;
	//====================================Login/Sign up
	public loginGUI(boolean isSignup, boolean isLoginCapabilities, boolean isLinked, ArrayList<Game> games) 
	{
		//================Moderator
		final Moderator master = new Moderator(1238793263, "SkyRocket", "Moderator", "secretSkyRocketModeratorUserName", "surreptitiousSkyRocketModeratorPassword", games);
		users.add(master);
		if(isSignup==false && isLoginCapabilities == true && isLinked == false) {
			this.setMinimumSize(new Dimension(1500,700));
			this.getContentPane().setLayout(null);
	
			JButton loginButton = new JButton("Login");
			loginButton.setBounds(80, 200, 100, 20);
			this.getContentPane().add(loginButton);
			
			JLabel userName = new JLabel("Username");
			userName.setBounds(55, 135, 100, 20);
			this.getContentPane().add(userName);
			
			JLabel password = new JLabel("Password");
			password.setBounds(55, 175, 100, 20);
			this.getContentPane().add(password);
			
			JTextField userNameTextField = new JTextField();
			userNameTextField.setBounds(155, 135, 389, 20);
			this.getContentPane().add(userNameTextField);
			
			JTextField passwordTextField = new JTextField();
			passwordTextField.setBounds(155, 175, 389, 20);
			this.getContentPane().add(passwordTextField);
			
			loginButton.addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent m) 
				{
					try {
						Scanner sc =null;
						sc = new Scanner(new File("userDatabaseFile.txt"));
						sc.nextLine();
						while(sc.hasNextLine())
						{
							String[]parts = sc.nextLine().split("\t");
							if((userNameTextField.getText()).equals(parts[3]) && (passwordTextField.getText()).equals(parts[4]))
							{
								users.add((new User(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], games)));
								(new User(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], games)).displayPage();
							}
						}
						sc.close();
					}
					catch(Exception e) {
						
					}
						
						if(userNameTextField.getText().isEmpty()) 
						{
							JFrame alert = new JFrame();
							alert.setMaximumSize(new Dimension(300, 300));
							alert.setBounds(150, 150, 200, 150);
							JLabel label = new JLabel("Username field is required");
							alert.add(label);
							alert.setVisible(true);
						}
						if(passwordTextField.getText().isEmpty()) 
						{
							JFrame alert = new JFrame();
							alert.setMaximumSize(new Dimension(300, 300));
							alert.setBounds(150, 350, 200, 150);
							JLabel label = new JLabel("Password field is required");
							alert.add(label);
							alert.setVisible(true);
						}
						
						
					}
					
					
				});
			
			
		}
		if(isSignup == true && isLoginCapabilities == true && isLinked == false) {
			this.setMinimumSize(new Dimension(1500,700));
			this.getContentPane().setLayout(null);
			JButton signupButton = new JButton("Sign up");
			signupButton.setBounds(80, 200, 100, 20);
			this.getContentPane().add(signupButton);
		
			jlabel = new JLabel("Sign up");
			jlabel.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
			this.add(jlabel);
			
			JLabel userName = new JLabel("Username");
			userName.setBounds(55, 135, 100, 20);
			this.getContentPane().add(userName);
			
			JLabel password = new JLabel("Password");
			password.setBounds(55, 175, 100, 20);
			this.getContentPane().add(password);
			this.getContentPane().add(jlabel);
			
			JLabel firstName = new JLabel("First Name");
			firstName.setBounds(55, 55, 100, 20);
			this.getContentPane().add(firstName);
			
			JLabel lastName = new JLabel("Last Name");
			lastName.setBounds(55, 95, 100, 20);
			this.getContentPane().add(lastName);
			
			JTextField userNameTextField = new JTextField();
			userNameTextField.setBounds(155, 135, 389, 20);
			this.getContentPane().add(userNameTextField);
			
			JTextField passwordTextField = new JTextField();
			passwordTextField.setBounds(155, 175, 389, 20);
			this.getContentPane().add(passwordTextField);
			
			JTextField firstnameTextField = new JTextField();
			firstnameTextField.setBounds(155, 55, 389, 20);
			this.getContentPane().add(firstnameTextField);
			
			JTextField lastnameTextField = new JTextField();
			lastnameTextField.setBounds(155, 95, 389, 20);
			this.getContentPane().add(lastnameTextField);
			
			User u = new User();
			
			signupButton.addMouseListener(new MouseAdapter() 
			{
				public void mouseClicked(MouseEvent m) 
				{
					Scanner sc =null;
					try 
					{
						sc = new Scanner(new File("userDatabaseFile.txt"));
						while(sc.hasNextLine())
						{
								String[]parts = sc.nextLine().split("\t");
							
								if(userNameTextField.getText().isEmpty()) 
								{
									JFrame alert = new JFrame();
									alert.setMaximumSize(new Dimension(300, 300));
									alert.setBounds(150, 150, 200, 150);
									JLabel label = new JLabel("Username field is required");
									alert.add(label);
									alert.setVisible(true);
									break;
								}
								if(passwordTextField.getText().isEmpty()) 
								{
									JFrame alert = new JFrame();
									alert.setMaximumSize(new Dimension(300, 300));
									alert.setBounds(150, 350, 200, 150);
									JLabel label = new JLabel("Password field is required");
									alert.add(label);
									alert.setVisible(true);
									break;
								}
								if(firstnameTextField.getText().isEmpty()) 
								{
									JFrame alert = new JFrame();
									alert.setMaximumSize(new Dimension(300, 300));
									alert.setBounds(350, 150, 200, 150);
									JLabel label = new JLabel("First Name field is required");
									alert.add(label);
									alert.setVisible(true);
								}
								if(lastnameTextField.getText().isEmpty()) 
								{
									JFrame alert = new JFrame();
									alert.setMaximumSize(new Dimension(300, 300));
									alert.setBounds(350, 350, 200, 150);
									JLabel label = new JLabel("Last Name field is required");
									alert.add(label);
									alert.setVisible(true);
								}
								
								else {
									int randomInt = (int)(Math.random()*2147483646);
									UsersCard uc = new UsersCard(randomInt, firstnameTextField.getText(), lastnameTextField.getText(), userNameTextField.getText(), passwordTextField.getText());
									User uOfficial = new User(randomInt, firstnameTextField.getText(), lastnameTextField.getText(), userNameTextField.getText(), passwordTextField.getText(), games);
									uOfficial.displayPage();
									users.add(uOfficial);
									break;
								}
							
							
						}
						
					}
					catch(Exception e) {
						
					}
					
				}
				});
			
			
			
		}
			
			//========================Login Button and Functionality: Verifies username and password
			
						
		
		/*else if(isLoginCapabilities == false && isLinked == false){
			this.setMinimumSize(new Dimension(800,400));
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, 0));
			jlabel = new JLabel(name);
			jlabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			this.add(jlabel);
			*/
		
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
