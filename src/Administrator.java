import java.util.ArrayList;

public class Administrator extends User{

	public Administrator(int userId, String firstName, String lastName, String userName, String password, ArrayList<Game> allOfTheGames) {
		super(userId, firstName, lastName, userName, password, allOfTheGames);
	}
	
	public boolean removeGame(Game g) {
		return true;
		
	}
}
