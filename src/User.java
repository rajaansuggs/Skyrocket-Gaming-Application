

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author rajaansuggs
 *
 */
public class User {
		//=======================properties
		private int userId;
		private String firstName;
		private String lastName;
		private String userName;
		private String password;
		private ArrayList<Game> games = new ArrayList<Game>();
		private boolean isFlagged;
		private boolean isActive;
		private HashMap<Comment, Game> commentForAGame = new HashMap<Comment, Game>();		
		private JFrame userPage;
		private JLabel label;
		private JPanel panel;
		//=======================constructors
		//=======================Sign In Constructor (sets all values to create User)
		public User(int userId, String firstName, String lastName, String userName, String password, ArrayList<Game> allOfTheGames) {
			setUserId(userId);
			setFirstName(firstName);
			setLastName(lastName);
			setUserName(userName);
			setUserPassword(password);
			for(Game g: allOfTheGames) {
				games.add(g);
			}
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
		

		@Override
		public int hashCode() 
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) 
		{
			if (this == obj)
				return true;
			if (!(obj instanceof User))
				return false;
			User other = (User) obj;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}
		
		
		public void addComment(Game g)
		{
			JTextArea comment = new JTextArea();
			comment.setMaximumSize(new Dimension(300, 300));
			comment.getText();
			comment.setVisible(true);
		}
		
		/*public void addGame() {
			
		}*/
		//========================Getters/Setters
		public int getUserId() 
		{
			return this.userId;
		}
		
		public void setUserId(int userId) 
		{
			this.userId = userId;
		}
		
		public String getLastName() 
		{
			return this.lastName;
		}
		
		public void setLastName(String lastName) 
		{
			this.lastName = lastName;
		}
		
		public String getFirstName() 
		{
			return this.firstName;
		}
		
		public void setFirstName(String firstName) 
		{
			this.firstName = firstName;
		}
		
		public String getUserPassword() 
		{
			return this.password;
		}
		
		public void setUserPassword(String password) 
		{
			this.password = password;		
		}
		
		public String getUserName() 
		{
			return userName;
		}
		
		public void setUserName(String userName) 
		{
			this.userName = userName;
		}
	
		@Override
		public String toString() 
		{
			return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
					+ userName + ", password=" + password + ", games=" + games + ", isFlagged=" + isFlagged + "]";
		}
		
		public boolean canLogin(String userName, String password, ArrayList<Game> games)
{
			try {
				isActive =false;
				Scanner sc =null;
				sc = new Scanner(new File("userDatabaseFile.txt"));
				sc.nextLine();
				while(sc.hasNextLine())
				{
					String[]parts = sc.nextLine().split("\t");
					if(parts[3].equals(userName) && parts[4].equals(password))
					{
						isActive = true;
					}
				}
				sc.close();
			}
			catch(Exception e) {
				
			}
			return isActive;
		}
	
}
