import java.io.RandomAccessFile;
import java.util.ArrayList;

public class User {
	//=======================properties
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private ArrayList<Game> games = new ArrayList<Game>();
	private boolean isFlagged;
	//=======================constructors
	public User(int userId, String firstName, String lastName, String userName, String password) {
		setUserId(userId);
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
		setUserPassword(password);
	}
	
	public User(RandomAccessFile raf) throws Exception{
		userId = raf.readInt();
		firstName = raf.readUTF();
		lastName = raf.readUTF();
		userName = raf.readUTF();
		password = raf.readUTF();


	}
	//========================Methods
	public void save(RandomAccessFile raf) throws Exception {
		raf.writeInt(userId);
		raf.writeUTF(firstName);
		raf.writeUTF(lastName);
		raf.writeUTF(userName);
		raf.writeUTF(password);

	}
	
	
	//========================Getters/Setters
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getUserPassword() {
		return this.password;
	}
	
	public void setUserPassword(String password) {
		this.password = password;		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", games=" + games + ", isFlagged=" + isFlagged + "]";
	}
	
	

}
