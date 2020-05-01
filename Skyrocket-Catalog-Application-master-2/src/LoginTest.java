

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import org.junit.Test;

public class LoginTest {
	@Test
	public void canLogin() {
		User u = null;
		Scanner scanner = null;
		ArrayList<Game> games = new ArrayList<Game>();
		try {
			scanner = new Scanner(new File("threeToFiveGames.txt"));
			scanner.nextLine();
			while(scanner.hasNextLine())
			{
				Game game = new Game(scanner);
				games.add(game);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		u = new User(1999720968,	"bee",	"cee",	"dee",	"ree", games);
		boolean verifyLogin2 = u.canLogin("dee", "ree", games);
		assertTrue(verifyLogin2);
	}
	/*
	@Test
	public void removeComments(String commentId)
	{
		Moderator.removeComment(commentId);
	}
	*/

}
