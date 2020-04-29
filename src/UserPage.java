import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserPage {
	private JFrame userPage;
	private JLabel label;
	private JPanel panel;
	private User user;
	private ArrayList<Game> games = new ArrayList<Game>();
	private Moderator mod = new Moderator(1238793263,	"SkyRocket",	"Moderator",	"secretSkyRocketModeratorUserName",	"surreptitiousSkyRocketModeratorPassword", games);
	public UserPage(User user) {
		this.user = user;
	}
	public void displayPage()
	{
		userPage = new JFrame(user.getFirstName() + " " + user.getLastName() + "'s Sky Rocket");
		label = new JLabel("Sky Rocket");
		panel = new JPanel();
		label.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
		JButton makeGameRequestButton = new JButton("Game Request");
		JButton makePostRequestButton =new JButton("Post Request");
		makeGameRequestButton.setBounds(400, 330, 190, 30);
		makeGameRequestButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				this.makeGameRequest();
			}

			private void makeGameRequest() {
				JFrame requestWindow = new JFrame();
				JButton addGameButton = new JButton("Add a Game");
				addGameButton.setBounds(400, 330, 190, 30);
				
				JTextField addGameNameText = new JTextField();
				addGameNameText.setBounds(330, 95, 300, 30);
				JLabel nameLabel = new JLabel("Game Name");
				nameLabel.setBounds(50, 95, 185, 30);


				JTextField addGameDescText = new JTextField();
				addGameDescText.setBounds(330, 135, 300, 30);
				JLabel descLabel = new JLabel("Game Description");
				descLabel.setBounds(50, 135, 185, 30);

				
				JTextField addExternalLink = new JTextField();
				addExternalLink.setBounds(330, 175, 300, 30);
				JLabel extLinkLabel = new JLabel("Game Link");
				extLinkLabel.setBounds(50, 175, 185, 30);

				JTextField userRating = new JTextField();
				userRating.setBounds(330, 215, 300, 30);
				JLabel userRatingLabel = new JLabel("Rate (represent as decimal)");
				userRatingLabel.setBounds(50, 215, 185, 30);
				
				JTextField companyText = new JTextField();
				companyText.setBounds(330, 255, 300, 30);
				JLabel companyTextLabel = new JLabel("Game Developer Company");
				companyTextLabel.setBounds(50, 255, 185, 30);

				JTextField compatibText = new JTextField();
				compatibText.setBounds(330, 295, 300, 30);
				JLabel compatibTextLabel = new JLabel("Platform");
				compatibTextLabel.setBounds(50, 295, 185, 30);
				
				addGameButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent m) {
						if(addGameNameText.getText().isEmpty()) {
							JFrame alert = new JFrame();
							alert.setMaximumSize(new Dimension(300, 300));
							alert.setBounds(150, 350, 200, 150);
							JLabel label = new JLabel("Game Name field is required");
							alert.add(label);
							alert.setVisible(true);
						}
						else if(addGameDescText.getText().isEmpty()) {
							JFrame alert = new JFrame();
							alert.setMaximumSize(new Dimension(300, 300));
							alert.setBounds(150, 350, 200, 150);
							JLabel label = new JLabel("Game Description field is required");
							alert.add(label);
							alert.setVisible(true);
						}
						else if(addExternalLink.getText().isEmpty()) {
							JFrame alert = new JFrame();
							alert.setMaximumSize(new Dimension(300, 300));
							alert.setBounds(150, 350, 200, 150);
							JLabel label = new JLabel("Game Link field is required");
							alert.add(label);
							alert.setVisible(true);
						}
						else if(mod.flagLink(addExternalLink.getText())) {
							JFrame alert = new JFrame();
							alert.setMaximumSize(new Dimension(600, 300));
							alert.setBounds(150, 350, 300, 200);
							JLabel label = new JLabel("Invalid link. Proper Domain Name is required");
							alert.add(label);
							alert.setVisible(true);
						}
						else {
							int randomInt = (int)(Math.random()*2147483646);
							Game g = new Game(randomInt, addGameNameText.getText(), addGameDescText.getText(), 0.0, addExternalLink.getText(), companyText.getText(), "theNewestVersion", compatibText.getText());
							mod.addGame(g);
							
						}
					}
				});
				
				/*
				b.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent m) {
						commentForAGame
						mod.flagComments();
					}
				});
				*/
				requestWindow.add(nameLabel);
				requestWindow.add(descLabel);
				requestWindow.add(extLinkLabel);
				requestWindow.add(userRatingLabel);
				requestWindow.add(companyTextLabel);
				requestWindow.add(compatibTextLabel);
				requestWindow.add(addGameButton);
				
				requestWindow.add(addGameNameText);
				requestWindow.add(addGameDescText);
				requestWindow.add(addExternalLink);
				requestWindow.add(userRating);
				requestWindow.add(companyText);
				requestWindow.add(compatibText);
				requestWindow.add(label);
				
				requestWindow.setMinimumSize(new Dimension(1200,900));
				requestWindow.pack();
				requestWindow.setVisible(true);
			}
		});
		panel.add(label);
		panel.add(makeGameRequestButton);
		panel.add(makePostRequestButton);
		userPage.add(panel);
		userPage.setMinimumSize(new Dimension(1200,900));
		userPage.pack();
		userPage.setVisible(true);
		
	}
}
