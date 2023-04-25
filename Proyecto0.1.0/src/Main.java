/**
 * Main.java
 * Programa principal del sistema para resolver un laberinto
 * DMS - 2023.01.11
 * version 0.1.0
 */

import Classes.Config;
import Classes.Session;
import Classes.Interface;
import Classes.Maze;

public class Main {
	public static Session userSession = new Session();
	private static  Maze maze;
	public static void main(String[] args) {
		System.out.println(Config.WELCOME);
		int option;
		maze=null;
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
			maze=new Maze();
			if (!maze.loadMaze()) {
				maze=null;
			}
			break;
		case 2:
			if (maze==null)  {
				System.out.print("No hay ningun laberinto cargado\n");
				break;
			}
			maze.showMap();
			break;
		case 3:
			if (maze==null)  {
				System.out.print("No hay ningun laberinto cargado\n");
				break;
			}
			if (!maze.setEntrancesExit()) {
				System.out.print("Ha habido un problema a la hora de marcar las casillas\n");
			}
			break;
		case 4:
			if (maze==null)  {
				System.out.print("No hay ningun laberinto cargado\n");
				break;
			}
			maze.solve();
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