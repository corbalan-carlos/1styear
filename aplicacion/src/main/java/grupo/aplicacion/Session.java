package grupo.aplicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
		System.out.print("Nombre de usuario:\n");
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
				System.out.print("Contraseña\n");
				input.readLine();
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
				buffUser=CharBuffer.allocate(userName.length()+1+buff.length());
				buffUser.mark();
				buffUser.append(userName);
				buffUser.append(":");
				buffUser.append(buff);
				break;
			}
		} while (true);
		StringBuilder[] sArr =new StringBuilder[8];
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
		System.out.print("Password:");
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
		String password=input.readLine();
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
		String role="User";
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
			output.append("\n");
			output.append(str.toString());
			output.flush();
		} catch (IOException e) {
			assert false:"bruh";
		}
		return true;
	}
	public void showUser() {
		System.out.print("Username: ");
		System.out.print(user.username+"\n");
		System.out.print("Name: ");
		System.out.print(user.name+"\n");
		System.out.print("NIF: ");
		System.out.print(user.nif+"\n");
		System.out.print("Email: ");
		System.out.print(user.email+"\n");
		System.out.print("Address: ");
		System.out.print(user.address+"\n");
		System.out.print("Birthdate: ");
		System.out.print(user.birthdate+"\n");
		System.out.print("Role: ");
		System.out.print(user.role+"\n");
	}
	public void logout() {
		user=null;
		logged=false;
		return;
	}
	
}
