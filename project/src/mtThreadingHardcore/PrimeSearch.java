/*
 * Carlos Corbalan Andreu
 * 18/11/22
 * 
 *  Clase PrimeSearch, es la clase que se dedica activamente a buscar primos
 * 
 */
package mtThreadingHardcore;
public class PrimeSearch extends Thread {
	//El numero que hay que comprobar si es primo
	int target;
	//El identificador del obeto
	public int threadN;
	/*El objeto giver, contiene un metodo que se encarga de actualizar
	 * el target conforme va comprabando si es primo o no*/
	private NumberGiver giver;
	@Override
	/*El metodo run es el ejecutado por el hilo*/ 
	public synchronized void run() {
		//Obtiene el primer target
		giver.giveNumber(this);
		//Mientras el bucle siga obteniendo nuevos targets el bucle sigue corriendo
		while (true) {
			/*El algoritmo de busqueda de primos*/
			for (int j=3;j<=target;j+=2) {
					if (target/j==1&&target%j==0) {
					//Muestra por pantalla el primo hallado
					//System.out.print(threadN+":"+target+"\n");
					//Aumenta el contador de primos 
					Counter.counter++;
					break;
				}
				if (target%j==0) break;
			}
			/*Una vez completado la busqueda de primo busca un nuevo target,
			 * si el metodo give number devuelve true significa que no quedan mas numeros
			 * que dar rompe el bucle y termina la busqueda de primos
			 */
			if (giver.giveNumber(this)) {
				break;
			}
		}
	}
	/*Constructor:
	 * n: El valor que se utilizará para representar el objeto
	 * numberGiver: El objeto de clase NumberGiver al cual pedirá numeros conforme
	 * 	vaya comprobando numeros
	 */
	PrimeSearch(int n, NumberGiver numberGiver) {
		this.threadN=n;
		this.giver=numberGiver;
	}
	
}
