/*
 * Carlos Corbalan Andreu
 * 18/11/22
 * 
 *  Clase Counter, se encarga de mantener la variable counter,
 *  la cual lleva cuenta la cantidad de primos que se han encontrado
 * 
 */
package mtThreadingHardcore;

import java.time.LocalTime;

public class Counter extends Thread{
	/*La cantidad de primos que se han encontrado (empieza en 2
	 * puesto que los primos 2 y 3 no son calculados) 
	 */
	static public int counter=2;
	
	/*Funcion
	 * Una vez inicia el metodo espera hasta que todos los primos 
	 * hayan sido hallados para ser reanimado por NumberGiver e 
	 * imprimir por pantalla la cantidad de primos encontrados
	 */
	@Override
	public void run() {
		synchronized (this) {
			try {
				this.wait();
			} catch (Exception E ) {
				System.out.print(E.getMessage());
			}
		}
		System.out.print(LocalTime.now()+"\n");
		System.out.print(counter+"\n");
	}
}
