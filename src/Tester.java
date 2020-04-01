import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	static ArrayList<Game> games = new ArrayList<Game>();
	public static void main(String[] args) {
		readGameData();
		new GraphicalUserInterface();
	}
	private static void readGameData() {
		//Scanner scanner = null;
		//String[] parts =null;
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
			
			for(int i=0; i<games.size(); i++) {
				System.out.println(games.get(i).getGameName());
			}
			
			
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
		}finally {
			
		}
	}

}
