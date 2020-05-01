import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
//Credit to https://tld-list.com/free-downloads for the top level domain names
public class Moderator extends User {
	//=========================Constructor
	public Moderator(int userid, String fn, String ln, String uname, String pass, ArrayList<Game> games) {
		super(userid, fn, ln, uname, pass, games);
		
	}

	//=========================methods
	public boolean flagLink(String link) {
		Scanner sc =null;
		boolean isFlagged = true;
		
		try {
			sc = new Scanner(new File("tld-list-basic.txt"));
			while(sc.hasNextLine()) {
				Pattern extensionPattern = Pattern.compile(".+\\."+sc.next()+"[/.+\\s]?");
				Matcher extensionMatcher = extensionPattern.matcher(link);
				if(extensionMatcher.matches()) {
					isFlagged = false;
				}
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return isFlagged;
			
	}
	
	public void addGame(Game game) {
			try {
				FileWriter saveFile = new FileWriter("threeToFiveGames.txt", true);
				BufferedWriter save = new BufferedWriter(saveFile);
				save.write(game.getGameId() + "\t");
				save.write(game.getGameName() +"\t");
				save.write(game.getGameDescription() +"\t");
				save.write(game.getStarRating() +"\t");
				save.write(game.getGameHyperLink() +"\t");
				save.write(game.getCompany() + "\t");
				save.write(game.getVersionNumber() +"\t");
				save.write(game.getCompatibleSystem()+"\t");
				save.newLine();
				save.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	

}
