import java.util.Scanner;

public class Game {
	//======================Instance Variables
	private int gameId;
	private String gameName, gameDescription, hyperlink, company, versionNumber, compatibleSystem;
	

	private GameRating rating;
	
	//======================Constructors
	public Game(Scanner scanner) {
		this(scanner.nextLine().split("\t"));
	}
	
	public Game(String[] games) {
		this(Integer.parseInt(games[0]), games[1], games[2], Double.parseDouble(games[3]), games[4], games[5], games[6], games[7]);
		
	}
	
	public Game(int gameId, String gameName, String gameDescription, double averageRating, String hyperlink, String company, String versionNumber, String compatibleSystem) {
		setGameId(gameId);
		setGameName(gameName);
		setGameDescription(gameDescription);
		setRating(new GameRating(gameId));
		setGameHyperLink(hyperlink);
		setCompany(company);
		setVersionNumber(versionNumber);
		setCompatibleSystem(compatibleSystem);
	}


	//======================Methods
	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", gameDescription=" + gameDescription
				+ ", hyperlink=" + hyperlink + ", company=" + company + ", versionNumber=" + versionNumber
				+ ", compatibleSystem=" + compatibleSystem + ", rating=" + rating + "]";
	}

	//Value will be truncated to 2 decimal places, then set out of 5 stars
	public double getStarRating() {
		double value = rating.getAvgRating();
		double rounded = (Math.round(value * 10.0))/2.0;
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
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getCompatibleSystem() {
		return compatibleSystem;
	}

	public void setCompatibleSystem(String compatibleSystem) {
		this.compatibleSystem = compatibleSystem;
	}

}
