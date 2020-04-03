import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicalUserInterface{
	private JLabel label;
	private JFrame window;
	private JLabel loginButton, signupButton;
	private Icon loginIcon, signupIcon;
	//====================================GUI constructor
	public GraphicalUserInterface(ArrayList<Game>games) {
		window = new JFrame("Sky Rocket");
		label = new JLabel("Sky Rocket");
		label.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 38));
		
		//====================================Sign up Page
		signupIcon = new ImageIcon(getClass().getResource("/resources/icons8-sign-up-64.png"));
		window.setMinimumSize(new Dimension(1500,700));
		signupButton = new JLabel(signupIcon); //Label's use addMouseListeners while JButton's addActionLAISTENER
		signupButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(true, "Sign up", false);
			}
		});
		//====================================Login Page
		loginIcon = new ImageIcon(getClass().getResource("/resources/icons8-enter-64.png"));
		loginButton = new JLabel(loginIcon); //Label's use addMouseListeners while JButton's addActionListener
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(true, "Login", false);
			}
		});
		window.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(label);
		topPanel.add(signupButton);
		topPanel.add(loginButton);
		JPanel centralPanel = new JPanel();
		JPanel southPanel = new JPanel();
		centralPanel.setLayout(new BoxLayout(centralPanel, 1));
		JLabel gi = new JLabel("Games Inventory");
		gi.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 17));
		centralPanel.add(gi);
		centralPanel.setLayout(new BoxLayout(centralPanel, 1));
		
		//====================================Sort games by name alphabetically
		JButton sort = new JButton("SORT");
		sort.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				ArrayList<String> sortedGameNames = sortAlphabetically(games);
				String aString = "";
				for(int i=0; i<sortedGameNames.size(); i++) {
					aString += sortedGameNames.get(i) +" ";
				}
				new loginGUI(false, aString, false);
			}
		});	
		topPanel.add(sort);	
		JLabel jl0 = new JLabel(games.get(0).getGameName() + "   ");
		jl0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(false, "Description: "+games.get(0).getGameDescription(), true);
			}
		});
		southPanel.add(jl0);
		String url0 = "https://clashroyale.com";
		JLabel link0 = new JLabel(url0);
		link0.setForeground(Color.BLUE);
		link0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		link0.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url0));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                link0.setText("Visit Clash Royale");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                link0.setText("<html><a href=''>Visit Clash Royale</a></html>");
            }
 
		});
		//=============================Credit of knowledge behind hyperlinking is www.codejava.net. https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
		JLabel jl1 = new JLabel(games.get(1).getGameName() + "   ");
		jl1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(false, "Description: "+games.get(1).getGameDescription(), true);
			}
		});
		southPanel.add(jl1);
		String url1="https://www.thesims3.com";
		JLabel link1 = new JLabel(url1);
		link1.setForeground(Color.BLUE);
		link1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		link1.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url1));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                link1.setText("Visit Sims");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                link1.setText("<html><a href=''>Visit Sims</a></html>");
            }
 
		});
		//==============================Mario Kart
		JLabel jl2 = new JLabel(games.get(2).getGameName() + "   ");
		jl2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {	
				new loginGUI(false, "Description: "+games.get(2).getGameDescription(), true);
			}
		});
		southPanel.add(jl2);
		String url2 = "https://play.google.com/store/apps/details?id=com.nintendo.zaka&hl=en_US";
		JLabel link2 = new JLabel(url2);
		link2.setForeground(Color.BLUE);
		link2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		link2.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url2));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                link2.setText("Visit Mario Kart Tour");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                link2.setText("<html><a href=''>Visit Mario Kart Tour</a></html>");
            }
 
		});
		//=============================Freezeria
		JLabel jl3 = new JLabel(games.get(3).getGameName() + "   ");
		jl3.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent m) {
			new loginGUI(false, "Description: "+games.get(3).getGameDescription(), true);
		}
		});	
		southPanel.add(jl3);
		String url3 = "https://www.coolmathgames.com/0-papas-freezeria";
		JLabel link3 = new JLabel(url3);
		link3.setForeground(Color.BLUE);
		link3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		link3.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url3));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                link3.setText("Visit Papa's Freezeria");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                link3.setText("<html><a href=''>Visit Papa's Freezeria</a></html>");
            }
 
		});
		//=========================BrawlStars
		JLabel jl4 = new JLabel(games.get(4).getGameName() + "   ");
		jl4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(false, "Description: "+games.get(4).getGameDescription(), true);		
			}
		});
		
		southPanel.add(jl4);
		String url4 = "https://play.google.com/store/apps/details?id=com.supercell.brawlstars&hl=en_US";
		JLabel link4 = new JLabel(url4);
		link4.setForeground(Color.BLUE);
		link4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		link4.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url4));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                link4.setText("Visit Brawl Stars");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                link4.setText("<html><a href=''>Visit Brawl Stars</a></html>");
            }
 
		});
		//========================MORTKOMB
		JLabel jl5 = new JLabel(games.get(5).getGameName() + "   ");
		jl5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {	
				new loginGUI(false, "Description: "+games.get(5).getGameDescription(), true);
			}
		});
		southPanel.add(jl5);
		String url5 = "https://www.mortalkombat.com";
		JLabel link5 = new JLabel(url5);
		link5.setForeground(Color.BLUE);
		link5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		link5.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url5));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                link5.setText("Visit Mortal Kombat");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                link5.setText("<html><a href=''>Visit Mortal Kombat</a></html>");
            }
 
		});
		//setLayout(new FlowLayout());
		southPanel.add(link0);
		southPanel.add(link1);
		southPanel.add(link2);
		southPanel.add(link3);
		southPanel.add(link4);
		southPanel.add(link5);
		//====================================Add everything to a top, center and bottom inner panels then Used a Border Layout in layered panels
		JPanel borderPnl = new JPanel(new BorderLayout());
		borderPnl.add(topPanel, BorderLayout.NORTH);
		borderPnl.add(centralPanel, BorderLayout.CENTER);
		borderPnl.add(southPanel, BorderLayout.SOUTH);

		//====================================Add to the window/JFrame
		window.add(borderPnl);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Sky Rocket");
		window.pack();
		window.setVisible(true);	

	}
	//====================================Private helper for sorting
	private ArrayList<String> sortAlphabetically(ArrayList<Game> games) {
		ArrayList <String> sortedGames = new ArrayList<String>();
		for (int i = 0; i < games.size(); i++) {
			sortedGames.add(games.get(i).getGameName());
		}
		Collections.sort(sortedGames);
		return sortedGames;
		
	}
	
}
