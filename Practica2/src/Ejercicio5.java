
/** 
 * Los operadores que tiene java son: 
 *  + - * / = == < > >= <= != i++ i-- ++i --i & | ^ && || ^^  ?i:j % 
 *  >> << >>>  += -= *= /= %= &= ^= |= <<= >>= >>>=
 */

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); //Operador de asignación
		int numOrden;			
		String nombre = "";		//Operador de asignación
		numOrden = 1 ;			//Operador de asignación
		System.out.println("Hola,");
		System.out.print("Soy un modesto ");
		System.out.print("programa de ordenador...\n");
		System.out.println("Bienvenido al Curso.\t" + "Este es el saludo nº " + numOrden);
		numOrden++;			//Operador de incremento post-uso
		System.out.println("Bienvenido a Java.\t" + "Este es el saludo nº " + numOrden);
		System.out.println("\nFin programa..."); 
	}
}