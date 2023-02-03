package grupo.aplicacion;

import java.io.IOException;

public class Main {
	static InputHelper in;
	public static void main(String[] args) {
		new Config();
		Config.userFile="users.txt";
		Config.mazeDir="mazes/";
		Session session=new Session(System.in);
		do {
			in=new InputHelper(System.in);
			System.out.print("1. Iniciar Sesion\n"
					+ "2. Registro\n"
					+ "0. Salir\n");
			String a=in.readLine();
			switch (a) {
				case "1": 
					try {
						if (session.login()) {
							loginMenu(session);
						}
					} catch (IOException e) {
						assert false:"bruh";
					}
					break;	
				case "2" :
					if (!session.signup()) {
						System.out.print("El registro ha fallado\n");
					}
					break;
				case "0": 
					System.out.print("Hasta luego");
					break;
				default: continue;
			}
		} while (true);
	}
	private static void loginMenu(Session currentLogin) {
		Maze maze=new Maze(System.in);
		do {
			System.out.print("1 Cargar laberinto\n"
				+ "2 Ver laberinto actual\n"
				+ "3 Establecer casillas de entrada y salida\n"
				+ "4 Buscar caminos\n"
				+ "5 Ver usuario actual\n"
				+ "6 Cerrar sesión\n"
				+ "0 Salir\n");
			String a=in.readLine();
			switch (a) {
				case "5": 
					currentLogin.showUser();
					break;
				case "6":
					currentLogin.logout();
					return;
				case "0": 
					System.exit(0);
				case "1":
					maze.loadMaze();
					break;
				case "2":
					maze.showMap();
					break;
				case "3":
					maze.setEntrancesExit();
					break;
				default:
					continue;
			}
		} while (true);
	}
	

}
