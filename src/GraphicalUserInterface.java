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
					aString += sortedGameNames.get(i) +"          ";
				}
				new loginGUI(false, aString, false);
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
		
		//setLayout(new FlowLayout());
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
