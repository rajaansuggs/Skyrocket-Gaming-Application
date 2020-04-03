import java.util.Scanner;

public class Game {
	//======================Instance Variables
	private int gameId;
	private String gameName;
	private String gameDescription;
	private double averageRating;
	
	//======================Constructors
	public Game(Scanner scanner) {
		this(scanner.nextLine().split("\t"));
	}
	
	public Game(String[] games) {
		this(Integer.parseInt(games[0]), games[1], games[2], Double.parseDouble(games[3]));
		
	}
	
	public Game(int gameId, String gameName, String gameDescription, double averageRating) {
		setGameId(gameId);
		setGameName(gameName);
		setGameDescription(gameDescription);
		setAverageRating(averageRating);
	}
	//======================Methods
	@Override
	public String toString() {
		return "Games gameId=" + gameId + ", gameName=" + gameName + ", gameDescription=" + gameDescription
				+ ", averageRating=" + averageRating;
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

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	
	

}
