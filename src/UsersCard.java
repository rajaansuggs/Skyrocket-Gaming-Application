import java.awt.Font;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class UsersCard {
	private ArrayList<User> users = new ArrayList<>();
	private final static String FILENAME = "user.bin";
	private String fileName;
	private int size = 0;
	public UsersCard(String defaultFilename) {
		setFileName(defaultFilename);
		load();
	}
	public void setFileName(String fileName) {
		fileName = fileName.toLowerCase().trim();
		if(fileName.length() == 0) fileName = FILENAME;
		if(!fileName.contains(".")) fileName += ".bin";
		if(fileName.startsWith(".")) fileName = "users" + fileName;
		this.fileName = fileName;
	}
	
	public void load() {
		if(!(new File(fileName)).exists()) return;
		
		RandomAccessFile raf = null;
		clearUsers();
		try {
			raf = new RandomAccessFile(fileName, "r");
			while(raf.getFilePointer() < raf.length())
				users.add(new User(raf));
		} catch (Exception e) {
			System.out.println("Error with the Random Access File");
		} finally {
			try {raf.close();} catch (Exception e) {}
		}
	}
	
	public void addUser(int userid, String fn, String ln, String uname, String pass) {
		new User(userid, fn, ln, uname, pass);
	}
	
	public void clearUsers() {
		users.clear();
	}
	
	
	@Override
	public String toString() {
		String ret = "";
		for(User s : users) {
			ret += String.format("%s\n", s);
		}
		return ret;
	}

}
