import java.util.Scanner;

public class Game {
	//======================Instance Variables
	private int gameId;
	private String gameName, gameDescription, hyperlink;
	private GameRating rating;
	
	//======================Constructors
	public Game(Scanner scanner) {
		this(scanner.nextLine().split("\t"));
	}
	
	public Game(String[] games) {
		this(Integer.parseInt(games[0]), games[1], games[2], Double.parseDouble(games[3]), games[4]);
		
	}
	
	public Game(int gameId, String gameName, String gameDescription, double averageRating, String hyperlink) {
		setGameId(gameId);
		setGameName(gameName);
		setGameDescription(gameDescription);
		setRating(new GameRating(gameId));
		setGameHyperLink(hyperlink);
	}


	//======================Methods
	@Override
	public String toString() {
		return "Games gameId=" + gameId + ", gameName=" + gameName + ", gameDescription=" + gameDescription
				+ ", averageRating=" + rating.getAvgRating() + ", hyperlink=" + hyperlink;
	}
	
	//Value will be truncated to 2 decimal places
	public double getAvgRating() {
		double value = rating.getAvgRating();
		double rounded = (Math.round(value * 100.0))/100.0;
		return rounded;
	}
	
	//======================Getters/Setters
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public GameRating getRating() {
		return rating;
	}

	public void setRating(GameRating rating) {
		this.rating = rating;
	}
	
	public String getGameHyperLink() {
		return hyperlink;
	}
	
	public void setGameHyperLink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	

}
