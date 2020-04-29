import java.util.ArrayList;
//Good work! Keep going
public class Comment {
	private int commentId, gameId;
	private String commentString;
	public Comment(int commentId, int gameId,String commentString) {
		setCommentId(commentId);
		setCommentString(commentString);
		setGameId(gameId);
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
