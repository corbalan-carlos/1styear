package a;

import java.util.Scanner;

public class Principal {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Dame un email\n");
		Utilidades.validarEmail(scanner.nextLine());
		System.out.print("Dame una password\n");
		Utilidades.validarPasword(scanner.nextLine());
		System.out.print("Dame una IPv4\n");
		Utilidades.validarIPv4(scanner.nextLine());
		System.out.print("Dame una fecha\n");
		Utilidades.validarFecha(scanner.nextLine());
	}
}
