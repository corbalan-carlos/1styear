/*
 * Carlos Corbalan Andreu
 * 18/11/22
 * 
 * Metodo Main, inicia los hilos para buscar los primos
 * 
 */
package mtThreadingHardcore;

import java.time.*;
public class Main {
	public static void main(String[] args) {
		System.out.print(LocalTime.now()+"\n");
		//Crea un nuevo NumberGiver
		NumberGiver giver=new NumberGiver(new Counter());
		//Crea los 3 PrimeSearch
		PrimeSearch a=new PrimeSearch(0,giver);
		PrimeSearch b=new PrimeSearch(1,giver);
		PrimeSearch c=new PrimeSearch(2,giver);
		//Inicia cada uno de los hilos
		a.start();
		b.start();
		c.start();
		
		
	}
	
}
