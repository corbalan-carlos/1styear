
	import java.util.Scanner;
	public class Ejercicio4 {
		static Scanner teclado = new Scanner(System.in);
		public static void main(String argumentos[]) {

			// Declaración de variables
			
			/*int TOPE = pedirTope(); 				// Constante, el máximo valor del múltiplo
			int mult  ;							// Almacena el múltiplo calculado
			int cont  ;							// Contador utilizado en el cálculo

			// Inicializa las variables
			mult = 0 ;
			cont = 0 ;
*/
			System.out.println("Múltiplos de 2");
			mostrarMultiplos2(pedirTope());
			teclado.close();
		}
		static void mostrarMultiplos2(final int TOPE) {
			for (int i=0;i<TOPE;i+=2) {
				System.out.println(i);
			}
		}
		static int pedirTope() {
			return teclado.nextInt();
		}
}
