import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
				new loginGUI(true, true, false, games);
			}
		});
		//====================================Login Page
		loginIcon = new ImageIcon(getClass().getResource("/resources/icons8-enter-64.png"));
		loginButton = new JLabel(loginIcon); //Label's use addMouseListeners while JButton's addActionListener
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(false, true, false, games);
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
					aString += sortedGameNames.get(i) +"          ";
				}
				new loginGUI(aString);
			}
		});	
		topPanel.add(sort);	
		JLabel jl0 = new JLabel(games.get(0).getGameName() + "   ");
		jl0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(games.get(0));
			}
		});
		southPanel.add(jl0);
		
		
		//=============================Credit of knowledge behind hyperlinking is www.codejava.net. https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
		JLabel jl1 = new JLabel(games.get(1).getGameName() + "   ");
		jl1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(games.get(1));
			}
		});
		southPanel.add(jl1);
		
		//==============================Mario Kart
		JLabel jl2 = new JLabel(games.get(2).getGameName() + "   ");
		jl2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {	
				new loginGUI(games.get(2));
			}
		});
		southPanel.add(jl2);
		
		//=============================Freezeria
		JLabel jl3 = new JLabel(games.get(3).getGameName() + "   ");
		jl3.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent m) {
			new loginGUI(games.get(3));
		}
		});	
		southPanel.add(jl3);
		
		//=========================BrawlStars
		JLabel jl4 = new JLabel(games.get(4).getGameName() + "   ");
		jl4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				new loginGUI(games.get(4));	

			}
		});
		
		southPanel.add(jl4);
		
		//========================MORTKOMB
		JLabel jl5 = new JLabel(games.get(5).getGameName() + "   ");
		jl5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {	
				new loginGUI(games.get(5));
			}
		});
		
		southPanel.add(jl5);
		southPanel.setLayout(new BoxLayout(southPanel, 1));
		
		//setLayout(new FlowLayout());
		//====================================Add everything to a top, center and bottom inner panels then Used a Border Layout in layered panels
		JPanel borderPnl = new JPanel(new BorderLayout(11,11));
		borderPnl.add(topPanel, BorderLayout.NORTH);
		borderPnl.add(centralPanel, BorderLayout.CENTER);
		
		
		
		//======================Search Bar
				JLabel searchLabel = new JLabel();
				JTextField searchBar = new JTextField();
				JButton searchButton = new JButton("Search");
				searchButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent m) {
						southPanel.setLayout(new BoxLayout(southPanel, 1));
						if(searchBar.getText().equalsIgnoreCase("Brawl Stars")){
							JLabel name = new JLabel("\n"+games.get(4).getGameName());
							JLabel desc = new JLabel("Description: "+games.get(4).getGameDescription());
							JLabel rate = new JLabel("Rating: "+games.get(4).getStarRating());
							JLabel company = new JLabel("Company: "+games.get(4).getCompany());
							JLabel version = new JLabel("Version: "+games.get(4).getVersionNumber());
							JLabel compatib = new JLabel("Compatibility Systems: "+games.get(4).getCompatibleSystem());
							addLabelToWindow(name, desc, rate, company,version, compatib);
						}
						else if(searchBar.getText().equalsIgnoreCase("Sims 89")){
							JLabel name = new JLabel("\n"+games.get(1).getGameName());
							JLabel desc = new JLabel("Description: "+games.get(1).getGameDescription());
							JLabel rate = new JLabel("Rating: "+games.get(1).getStarRating());
							JLabel company = new JLabel("Company: "+games.get(1).getCompany());
							JLabel version = new JLabel("Version: "+games.get(1).getVersionNumber());
							JLabel compatib = new JLabel("Compatibility Systems: "+games.get(1).getCompatibleSystem());
							addLabelToWindow(name, desc, rate, company,version, compatib);
						}
						else if(searchBar.getText().equalsIgnoreCase("Mario Kart")){
							JLabel name = new JLabel("\n"+games.get(2).getGameName());
							JLabel desc = new JLabel("Description: "+games.get(2).getGameDescription());
							JLabel rate = new JLabel("Rating: "+games.get(2).getStarRating());
							JLabel company = new JLabel("Company: "+games.get(2).getCompany());
							JLabel version = new JLabel("Version: "+games.get(2).getVersionNumber());
							JLabel compatib = new JLabel("Compatibility Systems: "+games.get(2).getCompatibleSystem());
							addLabelToWindow(name, desc, rate, company,version, compatib);
							
						}
						else if(searchBar.getText().equalsIgnoreCase("Uncles Ice Creameria")){
							JLabel name = new JLabel("\n"+games.get(3).getGameName());
							JLabel desc = new JLabel("Description: "+games.get(3).getGameDescription());
							JLabel rate = new JLabel("Rating: "+games.get(3).getStarRating());
							JLabel company = new JLabel("Company: "+games.get(3).getCompany());
							JLabel version = new JLabel("Version: "+games.get(3).getVersionNumber());
							JLabel compatib = new JLabel("Compatibility Systems: "+games.get(3).getCompatibleSystem());
							addLabelToWindow(name, desc, rate, company,version, compatib);
						}
						else if(searchBar.getText().equalsIgnoreCase("Mortal Kombat")){
							JLabel name = new JLabel("\n"+games.get(5).getGameName());
							JLabel desc = new JLabel("Description: "+games.get(5).getGameDescription());
							JLabel rate = new JLabel("Rating: "+games.get(5).getStarRating());
							JLabel company = new JLabel("Company: "+games.get(5).getCompany());
							JLabel version = new JLabel("Version: "+games.get(5).getVersionNumber());
							JLabel compatib = new JLabel("Compatibility Systems: "+games.get(5).getCompatibleSystem());
							addLabelToWindow(name, desc, rate, company,version, compatib);
						}
						else if(searchBar.getText().equalsIgnoreCase("Clash Royale")){
							JLabel name = new JLabel("\n"+games.get(0).getGameName());
							JLabel desc = new JLabel("Description: "+games.get(0).getGameDescription());
							JLabel rate = new JLabel("Rating: "+games.get(0).getStarRating());
							JLabel company = new JLabel("Company: "+games.get(0).getCompany());
							JLabel version = new JLabel("Version: "+games.get(0).getVersionNumber());
							JLabel compatib = new JLabel("Compatibility Systems: "+games.get(0).getCompatibleSystem());
							addLabelToWindow(name, desc, rate, company,version, compatib);;
						}
					}

					private void addLabelToWindow(JLabel name, JLabel desc, JLabel rate, JLabel co, JLabel versionNo, JLabel compatib) {	
						name.setFont(new Font("Serif", Font.PLAIN + Font.BOLD, 18));						
						southPanel.add(name);
						southPanel.add(desc);
						southPanel.add(rate);
						southPanel.add(co);
						southPanel.add(versionNo);
						southPanel.add(compatib);
						window.setVisible(true);
					}
				});
				
		southPanel.add(searchBar);
		southPanel.add(searchLabel);
		southPanel.add(searchButton);
		borderPnl.add(southPanel, BorderLayout.SOUTH);
		//borderPnl.setBorder((Border) new BorderLayout());
		//borderPnl.add(searchLabel, BorderLayout.EAST);
		//borderPnl.add(searchBar, BorderLayout.EAST);
		//====================================Add to the window/JFrame
		window.add(borderPnl);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Sky Rocket");
		window.pack();
		window.setVisible(true);	

	}
	//====================================Public helper for sorting
	public static ArrayList<String> sortAlphabetically(ArrayList<Game> games) {
		ArrayList <String> sortedGames = new ArrayList<String>();
		for (int i = 0; i < games.size(); i++) {
			sortedGames.add(games.get(i).getGameName());
		}
		Collections.sort(sortedGames);
		return sortedGames;
		
	}
	
}

