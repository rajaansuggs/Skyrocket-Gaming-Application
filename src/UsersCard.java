import java.io.*;
//==========================Constructor
public class UsersCard {
	public UsersCard(int userid, String fn, String ln, String uname, String pass) {
		load(userid, fn, ln, uname, pass);
	}
	
	public void load(int userid, String fn, String ln, String uname, String pass) {
		try {
			FileWriter saveFile = new FileWriter("userDatabaseFile.txt", true);
			BufferedWriter save = new BufferedWriter(saveFile);
			save.write(userid + "\t");
			save.write(fn +"\t");
			save.write(ln +"\t");
			save.write(uname +"\t");
			save.write(pass +"\t");
			save.newLine();
			save.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	



}
