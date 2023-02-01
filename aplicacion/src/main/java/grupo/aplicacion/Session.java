package grupo.aplicacion;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.BufferOverflowException;
import java.nio.CharBuffer;

public class Session {
	private User user;
	private boolean logged;
	private InputHelper input;
	private InputHelper userFile; 
	Session(InputStream input) {
		this.logged=false;
		this.user=null;
		this.input=new InputHelper(input);
		FileInputStream file=null;
		try {
			file = new FileInputStream(new File(Config.userFile));
		} catch (FileNotFoundException e) {
			assert false:"user file not found";
		}
		this.userFile=new InputHelper(file);
	}
	public boolean login() throws IOException {
		
		StringBuilder userName=new StringBuilder(20); 
		userName.append(input.readLine());
		return correctPassword(userName.toString());
	}
	private boolean correctPassword(String userName) {
		CharBuffer buffUser;
		do {
			CharBuffer a=CharBuffer.allocate(20);
			CharBuffer buff=null;
			try {
				buff=CharBuffer.wrap(userFile.readLine());
			} catch (NullPointerException e ) {
				return false;
			}
			while (buff.hasRemaining()) {
				char l=buff.get();
				if (l==':') break;
				a.append(l);
			}
			CharBuffer comparable=CharBuffer.allocate(20);
			comparable.append(userName);
			if (comparable.equals(a))  {
				buffUser=CharBuffer.allocate(userName.length()+1+a.length());
				buffUser.mark();
				buffUser.append(userName);
				buffUser.append(":");
				buffUser.append(buff);
				break;
			}
		} while (true);
		StringBuilder[] sArr =new StringBuilder[5];
		sArr[0]=new StringBuilder();
		buffUser.reset();
		for (int i=0,j=0;i<buffUser.length();i++) {
			char a=buffUser.get(i);
			if (a==':') {
				j++;
				sArr[j]=new StringBuilder();
				continue;
			}
			sArr[j].append(a);
		}
		if (sArr[1].toString().equals(input.readLine())) {
			this.user=new User();
			user.username=sArr[0].toString();
			user.name=sArr[2].toString();
			user.nif=sArr[3].toString();
			user.email=sArr[4].toString();
			user.address=sArr[5].toString();
			user.birthdate=sArr[6].toString();
			user.role=sArr[7].toString();
			return true;
		} else {
			return false;
		}
	}
	public boolean signup() {
		System.out.print("Username:\n");
		String username=input.readLine();
		do {
			CharBuffer a=CharBuffer.allocate(20);
			CharBuffer buff=null;
			try {
				buff=CharBuffer.wrap(userFile.readLine());
			} catch (NullPointerException e ) {
				break;
			}
			while (buff.hasRemaining()) {
				char l=buff.get();
				if (l==':') break;
				a.append(l);
			}
			CharBuffer comparable=CharBuffer.allocate(20);
			comparable.append(username);
			if (comparable.equals(a))  {
				return false;
			}
		} while (true);
		System.out.print("Password:\n");
		PrintStream buff =System.out;
		System.setOut(null);
		String password=input.readLine();
		System.setOut(buff);
		System.out.print("Name:\n");
		String name=input.readLine();
		System.out.print("NIF:\n");
		String nif=input.readLine();
		System.out.print("Email:\n");
		String emailString=input.readLine();
		System.out.print("Address:\n");
		String address=input.readLine();
		System.out.print("Birthdate:\n");
		String birthdate=input.readLine();
		String role=null;
		StringBuilder str =new StringBuilder();
		str.append(username);
		str.append(":");
		str.append(password);
		str.append(":");
		str.append(name);
		str.append(":");
		str.append(nif);
		str.append(":");
		str.append(emailString);
		str.append(":");
		str.append(address);
		str.append(":");
		str.append(birthdate);
		str.append(":");
		str.append(role);
		FileWriter output=null;
		try {
			output=new FileWriter(Config.userFile,true );
			output.write("\n");
			output.write(str.toString());
		} catch (IOException e) {
			assert false:"bruh";
		}
		return true;
	}
	public void showUser() {
		
	}
	public void logout() {
		user=null;
		logged=false;
	}
	
}
