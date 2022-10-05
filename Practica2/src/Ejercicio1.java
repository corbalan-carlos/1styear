/*
 	Tecnicamente hablando los comentarios no son una feature del lenguaje java
 	si no del compilador que no lee las líneas marcadas como comentario
 */

/*
 * No tengo ni idea a que se refiere con alfabeto java
 */

/*
 * Una sentencia es texto que responde a una sintaxis
 * con un sentido semántico que termina en ';'. Por ejemplo 
 *  "x=x;" sintácticamente tiene sentido pero semánticamente no
 *  mientras que "x mas 1 es igual a x" tiene sentido semánticamente
 *  pero no cumple la sintaxis del lenguaje
 */
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		/* teclado es un canal de entrada por teclado a través de un Scanner.
		   Necesita importar el paquete java.util
		 */
		Scanner teclado = new Scanner(System.in);
		
		int numOrden;			// Variable numérica.
		String nombre = "";		// Variable de texto. 
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