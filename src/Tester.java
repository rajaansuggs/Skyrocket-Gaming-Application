import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	static ArrayList<Game> games = new ArrayList<Game>();
	public static void main(String[] args) {
		readGameData();
		assignRatings();

		EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
        		new GraphicalUserInterface(games);

            }
        });
		
	}
	private static void readGameData() {
		Scanner scanner = null;
		try {
			scanner= new Scanner(new File("threeToFiveGames.txt"));
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				Game game = new Game(scanner);
				games.add(game);
			}
			scanner.close();
			
			
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
		}finally {
			
		}
	}
	
	private static void assignRatings() {
		Scanner scanner = null;
		try {
			scanner= new Scanner(new File("gameRatings.txt"));
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				GameRating rating = new GameRating(line);
				for (int i = 0; i < games.size(); i++) {
					if (games.get(i).getGameId() == rating.getGameId()) {
						games.get(i).setRating(rating);
					}
				}
			}
			scanner.close();
			
			
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
		}finally {
			
		}
		
	}

}
