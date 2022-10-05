

/**
 * Los datos primitivos que tiene java son:
 * void int long float double boolean byte char short
 */

/*
 * Los datos primitivos son atómicos, no son clases como el resto de tipos de datos en OOP
 * Estos son lo que forma los datos no primitivos. Se componen de su nombre y su valor. 
 */
/*
 * No hay ninguna constante 
 */
import java.util.Scanner;
public class Ejercicio2 {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in); //No primitivo

		int numOrden;			// Primitivo
		String nombre = "";		// No primitivo 

		
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
