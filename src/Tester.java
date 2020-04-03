import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	static ArrayList<Game> games = new ArrayList<Game>();
	public static void main(String[] args) {
		readGameData();

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
				//System.out.println(scanner.nextLine());
				Game game = new Game(scanner);
				games.add(game);
			}
			scanner.close();
			
			
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
		}finally {
			
		}
	}

}
