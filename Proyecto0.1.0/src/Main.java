/**
 * Main.java
 * Programa principal del sistema para resolver un laberinto
 * DMS - 2023.01.11
 * version 0.1.0
 */

import Classes.Config;
import Classes.Session;
import Classes.Interface;

public class Main {
	public static Session userSession = new Session();
	
	public static void main(String[] args) {
		System.out.println(Config.WELCOME);
		int option;
		
		do {
			if(userSession.isLogged()) {
				// Menu con login
				option = Interface.getInt(Config.LOGGED_MENU);
				loggedAction(option);
			} else {
				// Menu sin login
				option = Interface.getInt(Config.UNLOGGED_MENU);
				unloggedAction(option);
			}
			
		} while(option != 0);
		
		System.out.println(Config.GOODBYE);
	}
	
	public static void unloggedAction(int option) {
		switch(option) {
		case 1:
			userSession.login();
			break;
		case 2:
			userSession.signup();
			break;
		}
	}
	
	public static void loggedAction(int option) {
		switch(option) {
		case 1:
			System.out.println("PROXIMAMENTE");
			break;
		case 2:
			System.out.println("PROXIMAMENTE");
			break;
		case 3:
			System.out.println("PROXIMAMENTE");
			break;
		case 4:
			System.out.println("PROXIMAMENTE");
			break;
		case 5:
			userSession.showUser();
			break;
		case 6:
			userSession.logout();
			break;
		}
	}	
}