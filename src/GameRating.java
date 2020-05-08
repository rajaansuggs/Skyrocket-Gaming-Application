import java.util.ArrayList;

public class GameRating {
	
	private int gameId;
	private ArrayList<Rating> ratings;
	
	public GameRating(String line) {
		gameId = Integer.parseInt(line.substring(0, line.indexOf('\t')));
		line = line.substring(line.indexOf('\t') + 1);
		
		ratings = new ArrayList<Rating>();
		while (line.length() > 0) {
			double value = Double.parseDouble(line.substring(0,line.indexOf(' ')));
			line = line.substring(line.indexOf(' ') + 1);
			String user = line.substring(0,line.indexOf(' '));
			line = line.substring(line.indexOf(' ') + 1);
			
			Rating nextRating = new Rating(value, user);
			ratings.add(nextRating);
		}
		
	}
	
	public GameRating(int gameId) {
		this.gameId = gameId;
		ratings = null;
	}
	
	
	public int getGameId() {
		return gameId;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}



	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	public double getAvgRating() {
		if (ratings == null) {
			return 0;
		}
		
		double total = 0;
		for (int i = 0; i < ratings.size(); i++) {
			total += ratings.get(i).rateValue;
		}
		return total/ratings.size();
	}
	
	private class Rating {
		
		private double rateValue;
		private String userID;
		
		public Rating(double value, String user) {
			rateValue = value;
			userID = user;
		}
	}
	
}
	
