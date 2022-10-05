/*
 * Una variable no es más que un valor referenciado por su identificador
 */

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		/* teclado es un canal de entrada por teclado a través de un Scanner.
		   Necesita importar el paquete java.util
		 */
		Scanner teclado = new Scanner(System.in); /*teclado es una instancia de la clase Scaner 
												que se utiliza para leer datos de un byte stream
										*/

		int numOrden;			// Guarda un valor numérico
		String nombre = "";		// Guarda una secuancia de caracteres

		// Configura y muestra mensajes de bienvenida.
		numOrden = 1 ;
		System.out.println("Hola,");
		System.out.print("Soy un modesto ");
		System.out.print("programa de ordenador...\n");
		System.out.println("Bienvenido al Curso.\t" + "Este es el saludo nº " + numOrden);
		numOrden++;
		System.out.println("Bienvenido a Java.\t" + "Este es el saludo nº " + numOrden);
		System.out.println("\nFin programa..."); 
	}
}