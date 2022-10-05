/*
 * Las siguientes palabras son reservadas del lenguaje java:
 *  import class public private protected volatile new void int 
 *  char float double long class abstract catch final implements
 *  native switch true assert do finally return synchronized try
 *  boolean else instaceof null short this break const enum for package 
 *  static throw byte continue extends goto interface strictfp throws
 *  while case default false if super transient
 */

/*
 * Es una palabra que sigue ciertos criterios cuyo uso es ser una referencia
 * hacia un valor guardado en memoria
 */
import java.util.Scanner; //Indica que clase hay que referenciar 
 
public class Ejercicio3 { 
	/*public indica que está clase podrá ser vista por todas las demás clases
	class indica que se está declarando una clase
*/
	public static void main(String[] args) {/* static indica que este método
						podrá utilizarse sin necesidad de instaciar la clase 
						void indica que el metodo no devuelve ningún valor
	*/
		/* teclado es un canal de entrada por teclado a través de un Scanner.
		   Necesita importar el paquete java.util
		 */
		Scanner teclado = new Scanner(System.in); 
		//new indica que se va a crear una nueva instancia de la clase Scanner

		int numOrden;			// int indica que se crea una nueva variable de tipo int
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