/*
 * Carlos Corbalan Andreu
 * 18/11/22
 * 
 *  Clase NumberGiver, se encarga de asignar la variable 
 *  PrimeSearch.target
 * 
 */
package mtThreadingHardcore;

public class NumberGiver {
	/*Esta variable se encarga de guardar el valor que se le asignara a 
	 *PrimeSearch.target la siguiente vez que se llame giveNumber
	 */
	private static int i=3;
	//Guarda cual es el limite de la busqueda de primos
	final private static int MAX=1000000-2;
	//Se guarda el objeto counter que se encarga de mantener un contador de los primos encontrados
	public Counter counter;
	//Se utiliza para saber cuantos hilos corriendo PrimeSearch han parado
	private int timesStopped=0;
	/*
	 * Metodo:
	 * caller: Guarda cual es el objeto PrimeSearch que ha pedido un nuevo target
	 * return:
	 * 	true: Si se ha llegado al MAX
	 * 	false: Si no se ha llegado al MAX
	 * 
	 * Primero comprueba si la variable i ha llegado a MAX, si es asi 
	 * comprueba que los hilos ejecutando PrimeSearch han llegado al MAX
	 * En el caso que todos los hilos hayan parado ya notifica al hilo ejecutando
	 * Counter que ya se ha terminado la busqueda y este retoma su ejecucion
	 * Si no incrementa el numero de hilos PrimeSearch que han terminado su ejecucion
	 * En cualquier caso devuelve true
	 * 
	 * En el caso que la variable i no haya llegado a MAX aumenta i en 2 y pone el target
	 * de caller con valor i y devuelve falso
	 */
	synchronized public boolean giveNumber (PrimeSearch caller){
		if (NumberGiver.i>MAX) {
			if (this.timesStopped==2) {
				synchronized (counter) {
					counter.notify();
				}
			} else {
				timesStopped++;
			}
			return true;
		}
		caller.target=i+=2;
		return false;
	}
	/*Constructor:
	 * 	counter:Asigna el objeto contador que tendra corriendo un hilo
	 * 			y empieza el hilo 	
	 */
	NumberGiver(Counter counter) {
		this.counter=counter;
		counter.start();
	}
}
