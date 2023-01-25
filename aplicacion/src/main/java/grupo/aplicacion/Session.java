package grupo.aplicacion;

import java.io.Console;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Session {
	private User user;
	private boolean logged;
	Session() {
		this.logged=false;
		this.user=null;
	}
	//TODO 
	public boolean login(String userS) {
		
	}
	//TODO dependiente de login();
	private boolean correctPassword(String userName) {
		InputHelper in =new InputHelper(System.in);
		in.readLine();
	}
	public User signup() {
		
	}
	public void showUser() {
		
	}
	public void logout() {
		user=null;
		logged=false;
	}
	
}
