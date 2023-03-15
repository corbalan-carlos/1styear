package Classes;

import java.util.ArrayList;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Session {
	private User user;
	private boolean logged;

	public Session() { // CONSTRUCTOR
		this.logged = false;
		this.user = new User();
	}

	public boolean isLogged() {
		return this.logged;
	}

	public void login() {
		String username = Interface.getString("Nombre de usuario: ");
		if (username.length() == 0) {
			System.err.println("\nEl usuario esta vacio\n");
			return;
		}

		String password = Interface.getString("Password: ");
		if (password.length() == 0) {
			System.err.println("\nEl password esta vacio\n");
			return;
		}
		// Comprobar
		ArrayList<String> lines = this.readAllUsers();
		for (int i = 0; i < lines.size(); i++) {
			String currentLine = lines.get(i);
			String[] currentUser = currentLine.split("#");

			if (currentUser[0].equalsIgnoreCase(username) && currentUser[1].equals(password)) {
				this.logged = true;
				this.user.username = currentUser[0];
				this.user.name = currentUser[2];
				this.user.nif = currentUser[3];
				this.user.email = currentUser[4];
				this.user.address = currentUser[5];
				this.user.birthdate = currentUser[6];
				this.user.role = currentUser[7];

				break;
			}
		}

		if (this.logged) {
			System.out.println("\nSesion iniciada con exito!");
		} else {
			System.out.println("\nUsuario y/o password incorrectos");
		}
	}

	private ArrayList<String> readAllUsers() {
		ArrayList<String> allUsers = new ArrayList<String>();

		try {
			File myObj = new File(Config.FILE_PATH + Config.USERS_FILE);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				allUsers.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return allUsers;
	}

	public void signup() { // Registro
		String username = Interface.getString("Nombre de usuario: ");
		if (username.length() == 0) {
			System.out.println("\nEl usuario no debe estar vacio\n");
			return;
		}
		if (this.checkUser(username)) {
			System.out.println("\nEl usuario ya existe!\n");
			return;
		}
		String password = Interface.getString("Password: ");
		String name = Interface.getString("Nombre completo: ");
		String nif = Interface.getString("NIF: ");
		String email = Interface.getString("Email: ");
		String address = Interface.getString("Direccion: ");
		String birthdate = Interface.getString("Fecha nacimiento: ");

		String newLine = "\n" + username + "#" + password + "#" + name + "#" + nif + "#" + email + "#" + address + "#"
				+ birthdate + "#user";
		// System.out.println(newLine);
		// Escribir en fichero
		try {
			FileWriter myWriter = new FileWriter(Config.FILE_PATH + Config.USERS_FILE, true);
			myWriter.write(newLine);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println("\nUSUARIO REGISTRADO CON EXITO\n");
	}

	private boolean checkUser(String username) {
		boolean exists = false;

		ArrayList<String> lines = this.readAllUsers();

		for (int i = 0; i < lines.size(); i++) {
			String[] currentUser = lines.get(i).split("#");
			if (currentUser[0].equalsIgnoreCase(username)) {
				exists = true;
				break;
			}
		}

		return exists;
	}

	public void showUser() {
		System.out.println("\nUSUARIO ACTUAL");
		System.out.println("--------------");
		System.out.println("Nombre de usuario: " + this.user.username);
		System.out.println("Nombre completo: " + this.user.name);
		System.out.println("NIF: " + this.user.nif);
		System.out.println("Email: " + this.user.email);
		System.out.println("Direccion: " + this.user.address);
		System.out.println("Fecha nacimiento: " + this.user.birthdate);
		System.out.println("Rol de usuario: " + this.user.role);
		System.out.println("\n");
	}

	public void logout() {
		this.logged = false;
		this.user = new User();
		System.out.println("\nSesion cerrada\n");
	}

}