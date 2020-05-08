import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserPage {
	private JFrame userPage;
	private JLabel label;
	private User user;
	private ArrayList<Comment> comments = new ArrayList<>();
	private ArrayList<Game> games = new ArrayList<Game>();
	private Moderator mod = new Moderator(1238793263,	"SkyRocket",	"Moderator",	"secretSkyRocketModeratorUserName",	"surreptitiousSkyRocketModeratorPassword", games);
	private Administrator admin = new Administrator(1, "AdminFirstname",	"AdminLastname",	"Admin",	"AdminPassword", games);
	private HashMap<JButton, Game> gameAndButton;
	//=========================Constructor
	public UserPage(User user, ArrayList<Game> games) {
		this.user = user;
		this.games = games;
		
	}
	//=========================Methods
	public void displayPage()
	{
		userPage = new JFrame(user.getFirstName() + " " + user.getLastName() + "'s Sky Rocket");
		label = new JLabel("Sky Rocket");
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		label.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
		JButton makeGameRequestButton = new JButton("Game Request");
		JButton viewGameCommentsButton = new JButton("View Game Comments");
		gameAndButton = new HashMap<JButton, Game>();
		panel = new JPanel();
		panel.add(label);
		panel.add(makeGameRequestButton);
		panel.add(viewGameCommentsButton);
		JPanel secondaryLayer = new JPanel();
		JPanel primaryPanel = new JPanel();
		secondaryLayer.setLayout(new BoxLayout(secondaryLayer, 1));
		for(Game g: games) {
			gameAndButton.put(new JButton("Post"), g);
			JLabel gameLabel = new JLabel(g.getGameName());
			JButton jb = new JButton("Post");
			jb.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent m) {
					JFrame commentFrame =new JFrame("Post Submission Page");
					JTextArea comment = new JTextArea();
					JLabel gameLabel = new JLabel(g.getGameName());
					gameLabel.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
					JLabel postLabel = new JLabel("Post a review about " + g.getGameName());
					JButton postComment = new JButton("Submit");
					JPanel postPanel = new JPanel(){
					    @Override
					    public Dimension getPreferredSize() {
					        return new Dimension(400, 400);
					    };
					};
					JLabel companyLabel = new JLabel("Game Company: "+g.getCompany());
					JLabel versionLabel = new JLabel("Current Available Version: "+g.getVersionNumber());
					String gameURL = g.getGameHyperLink();
					JLabel linkLabel = new JLabel("Go to: "+gameURL);
					linkLabel.setForeground(Color.BLUE);
					linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					linkLabel.addMouseListener(new MouseAdapter() {
						@Override
			            public void mouseClicked(MouseEvent e) {
			                try {
			                    Desktop.getDesktop().browse(new URI(gameURL));
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
					JLabel systemLabel = new JLabel("Compatible Systems: "+g.getCompatibleSystem());
					JLabel gameNameLabel = new JLabel(g.getGameName());
					postPanel.setLayout(null);
					
					gameNameLabel.setBounds(700, 290, 400, 15);
					systemLabel.setBounds(700, 310, 400, 15);
					companyLabel.setBounds(700, 330, 400, 15);
					versionLabel.setBounds(700, 350, 400, 15);
					linkLabel.setBounds(700, 370, 700, 15);
					
					comment.setBounds(100, 250, 500, 500);
					postLabel.setBounds(220, 225, 380, 10);
					gameLabel.setBounds(200, 25, 400, 100);
					postComment.setBounds(250, 110, 100, 50);
					
					postPanel.add(postLabel);
					postPanel.add(gameLabel);
					postPanel.add(postComment);
					postPanel.add(comment);
					postPanel.add(companyLabel);
					postPanel.add(versionLabel);
					postPanel.add(linkLabel);
					postPanel.add(systemLabel);
					postPanel.add(gameNameLabel);
					commentFrame.add(postPanel);
					int randomInt = (int)(Math.random()*2147483646);
					postComment.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent m) {
							Comment newComment = new Comment(user.getUserName(), randomInt, g.getGameName(), comment.getText());
							newComment.load(user.getUserName(), randomInt, g.getGameName(), comment.getText());
							comments.add(newComment);
						}
					});
					commentFrame.setMinimumSize(new Dimension(1400,900));
					commentFrame.pack();
					commentFrame.setVisible(true);
					commentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}
			});
			secondaryLayer.add(gameLabel);
			secondaryLayer.add(jb);
			primaryPanel.add(panel, BorderLayout.NORTH);
			primaryPanel.add(secondaryLayer, BorderLayout.CENTER);

		}
		viewGameCommentsButton.setBounds(300, 700, 200, 200);
		viewGameCommentsButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				JFrame commentWindow = new JFrame("In The Trenches of The Game Comments");
				commentWindow.setMinimumSize(new Dimension(1200,900));
				JPanel commentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				Scanner sc = null;
				try {
					sc = new Scanner(new File("commentSection.txt"));
					while(sc.hasNextLine()) {
						String[]parts = sc.nextLine().split("\t");
						comments.add(new Comment(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]));
						JLabel commentUserLabel = new JLabel("Game: "+parts[2]+"     Username: "+parts[0]+ "    Comment > "+parts[3]);
						commentPanel.add(commentUserLabel);
					}
					commentWindow.add(commentPanel);
					commentWindow.pack();
					commentWindow.setVisible(true);
					commentWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}catch(Exception e) {
					e.getMessage();
				}
				
				
				
				
			}
		});
		
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
							JLabel label = new JLabel("Invalid link. Proper Link is required");
							alert.add(label);
							alert.setVisible(true);
						}
						else {
							if(!mod.validRating(userRating.getText())) {
								JFrame alert = new JFrame();
								alert.setMinimumSize(new Dimension(800, 300));
								alert.setBounds(800, 350, 300, 200);
								JLabel label = new JLabel("Invalid rating. Proper Rating (inclusive between 0 and 1) is required");
								alert.add(label);
								alert.setVisible(true);
							}
							else {
								JFrame alert = new JFrame();
								alert.setMinimumSize(new Dimension(600, 300));
								alert.setBounds(150, 350, 300, 200);
								JLabel label = new JLabel("Success in adding the new game: " + addGameNameText.getText());
								alert.add(label);
								alert.setVisible(true);
								
								int randomInt = (int)(Math.random()*2147483646);
								Game g = new Game(randomInt, addGameNameText.getText(), addGameDescText.getText(), 0.0, addExternalLink.getText(), companyText.getText(), "theNewestVersion", compatibText.getText());
								mod.addGame(g);
							}
							
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
		if(this.user.equals(admin)) {
			JButton deleteGames = new JButton("Delete a game");
			JTextField searchGames = new JTextField();
			JLabel blankLabel = new JLabel();
			primaryPanel.add(blankLabel);
			blankLabel.setPreferredSize(new Dimension(700, 50));
			primaryPanel.add(deleteGames);
			primaryPanel.add(searchGames);
			JLabel labelUserDesc = new JLabel("Instructions for User Removals: Enter given username's only");
			JLabel labelGameDesc = new JLabel("Instructions for Game Removals: Enter given game name's only");
			primaryPanel.add(labelGameDesc);
			labelGameDesc.setPreferredSize(new Dimension(500, 50));	
			primaryPanel.add(labelUserDesc);
			labelUserDesc.setPreferredSize(new Dimension(500, 50));	
			searchGames.setPreferredSize(new Dimension(700, 50));	
			deleteGames.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						int pos = 1;
						String temporaryName = "tmp.txt";
						String path = "threeToFiveGames.txt";
						File prevFile = new File(path);
						File newFile = new File(temporaryName);
						String currLine;
						String gameData[];

						try {
						    FileWriter fWriter = new FileWriter(temporaryName,true);
							BufferedWriter buffWriter = new BufferedWriter(fWriter);
							PrintWriter priWriter = new PrintWriter(buffWriter);
							FileReader fReader = new FileReader(path);
							BufferedReader buffReader = new BufferedReader(fReader);
							while((currLine = buffReader.readLine()) != null){
								gameData = currLine.split("\t");
								if(!(gameData[pos].equalsIgnoreCase(searchGames.getText()))) {
									priWriter.println(currLine);
								}
								else {
									JFrame alert = new JFrame();
									alert.setMinimumSize(new Dimension(600, 300));
									alert.setBounds(150, 350, 300, 200);
									JLabel label = new JLabel("Success in removing (the game) " + searchGames.getText() +" from the system!");
									alert.add(label);
									alert.setVisible(true);
								}
							}
							
							priWriter.flush();
							priWriter.close();
							fWriter.close();
							buffWriter.close();
							fReader.close();
							buffReader.close();
							prevFile.delete();
							File reNaming = new File(path);
							newFile.renameTo(reNaming);
						 } catch (IOException exc) {
						       // TODO Auto-generated catch block
						       exc.printStackTrace();
						 }
						
					}catch(Exception exc) {
						exc.getMessage();
					}
				}
			});
			
			
			JButton deleteUsers = new JButton("Delete a user");
			JTextField searchUsers = new JTextField();
			primaryPanel.add(deleteUsers);
			primaryPanel.add(searchUsers);
			searchUsers.setPreferredSize(new Dimension(600, 50));	
			deleteUsers.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						int pos = 3;
						String temporaryName = "tmp.txt";
						String path = "userDatabaseFile.txt";
						File prevFile = new File(path);
						File newFile = new File(temporaryName);
						String currLine;
						String userData[];

						try {
						    FileWriter fWriter = new FileWriter(temporaryName,true);
							BufferedWriter buffWriter = new BufferedWriter(fWriter);
							PrintWriter priWriter = new PrintWriter(buffWriter);
							FileReader fReader = new FileReader(path);
							BufferedReader buffReader = new BufferedReader(fReader);
							while((currLine = buffReader.readLine()) != null){
								userData = currLine.split("\t");
								if(!(userData[pos].equalsIgnoreCase(searchUsers.getText()))) {
									priWriter.println(currLine);
								}
								else {
									JFrame alert = new JFrame();
									alert.setMinimumSize(new Dimension(600, 300));
									alert.setBounds(150, 350, 300, 200);
									JLabel label = new JLabel("Success in removing (the user) " + searchUsers.getText() + " from the system!");
									alert.add(label);
									alert.setVisible(true);
								}
							}
							
							priWriter.flush();
							priWriter.close();
							fWriter.close();
							buffWriter.close();
							fReader.close();
							buffReader.close();
							prevFile.delete();
							File reNaming = new File(path);
							newFile.renameTo(reNaming);
						 } catch (IOException exc) {
						       // TODO Auto-generated catch block
						       exc.printStackTrace();
						 }
						
					}catch(Exception exc) {
						exc.getMessage();
					}
				}
			});
			
			JButton deleteComments = new JButton("Delete a comment (use commentId)");
			JTextField searchComments = new JTextField();
			primaryPanel.add(deleteComments);
			primaryPanel.add(searchComments);
			searchComments.setPreferredSize(new Dimension(400, 50));	
			deleteComments.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						int pos = 1;
						String temporaryName = "tmp.txt";
						String path = "commentSection.txt";
						File prevFile = new File(path);
						File newFile = new File(temporaryName);
						String currLine;
						String commentData[];

						try {
						    FileWriter fWriter = new FileWriter(temporaryName,true);
							BufferedWriter buffWriter = new BufferedWriter(fWriter);
							PrintWriter priWriter = new PrintWriter(buffWriter);
							FileReader fReader = new FileReader(path);
							BufferedReader buffReader = new BufferedReader(fReader);
							while((currLine = buffReader.readLine()) != null){
								commentData = currLine.split("\t");
								if(!(commentData[pos].equalsIgnoreCase(searchComments.getText()))) {
									priWriter.println(currLine);
								}
								else {
									JFrame alert = new JFrame();
									alert.setMinimumSize(new Dimension(600, 300));
									alert.setBounds(150, 350, 300, 200);
									JLabel label = new JLabel("Success in removing (the comment) " + searchComments.getText() + " from the system!");
									alert.add(label);
									alert.setVisible(true);
								}
							}
							
							priWriter.flush();
							priWriter.close();
							fWriter.close();
							buffWriter.close();
							fReader.close();
							buffReader.close();
							prevFile.delete();
							File reNaming = new File(path);
							newFile.renameTo(reNaming);
						 } catch (IOException exc) {
						       // TODO Auto-generated catch block
						       exc.printStackTrace();
						 }
						
					}catch(Exception exc) {
						exc.getMessage();
					}
				}
			});
		}
		
		userPage.add(primaryPanel);
		userPage.setMinimumSize(new Dimension(1200,900));
		userPage.pack();
		userPage.setVisible(true);
		userPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}

