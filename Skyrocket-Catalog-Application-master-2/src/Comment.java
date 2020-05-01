import java.io.BufferedWriter;
import java.io.FileWriter;

//Good work! Keep going
public class Comment {
	private int commentId, gameId, userId;
	private String commentString;
	public Comment(int userId, int commentId, int gameId, String commentString) {
		setUserId(userId);
		setCommentId(commentId);
		setCommentString(commentString);
		setGameId(gameId);
		load(userId, commentId, gameId, commentString);
	}
	
	private void load(int userId, int commentId, int gameId, String commentString) {
		try {
			FileWriter saveFile = new FileWriter("commentSection.txt", true);
			BufferedWriter save = new BufferedWriter(saveFile);
			save.write(userId + "\t");
			save.write(commentId +"\t");
			save.write(gameId +"\t");
			save.write(commentString +"\t");
			save.newLine();
			save.close();
		}
		catch(Exception e) {
			
		}
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentString() {
		return commentString;
	}
	public void setCommentString(String commentString) {
		this.commentString = commentString;
	}
	
}
