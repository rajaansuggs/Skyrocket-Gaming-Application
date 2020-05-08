import java.io.BufferedWriter;
import java.io.FileWriter;

//Good work! Keep going
public class Comment {
	private int commentId;
	private String commentString, gameName, userName;
	public Comment(String userName, int commentId, String gameName, String commentString) {
		setUserName(userName);
		setCommentId(commentId);
		setGameName(gameName);
		setCommentString(commentString);
		
	}
	
	public void load(String userName, int commentId, String gameName, String commentString) {
		try {
			FileWriter saveFile = new FileWriter("commentSection.txt", true);
			BufferedWriter save = new BufferedWriter(saveFile);
			save.write(userName + "\t");
			save.write(commentId +"\t");
			save.write(gameName +"\t");
			save.write(commentString +"\t");
			save.newLine();
			save.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
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


