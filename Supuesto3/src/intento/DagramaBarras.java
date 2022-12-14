/*
 * Carlos Corbalan Andreu
 * 
 *7/12/22
 *
 * Genera barras horizontal utilizando caracteres
 */

package intento;

public class DagramaBarras {
	/*Declaracion de constantes
	 * LIMITE_SUPERIOR: Indica cual es numero maximo para el 
	 * cual se computaran los metodos de la clase
	 * LIMITE_INFERIOR: Indica cual es el numer minimo par el 
	 * cual se computaran los metodos de la clase
	 * CARACTER_BASE: Que caracter se utilizará para mostrar el resultado
	 */
	static final int LIMITE_SUPERIOR=10;
	static final int LIMITE_INFERIOR=-10;
	static final char CARACTER_BASE='#';
	/*Funcion main(), se encarga de llamar a la funcion generarBarraHorizontal()
	 * junto con el argumento correspondiente
	 */
	public static void main(String args[]) {
		for (int i=LIMITE_INFERIOR-1;i<=LIMITE_SUPERIOR+1;i++) {
			System.out.print(generarBarraHorizontal(i)+"\n");
		}
	}
	/*Funcion generarBarraHorizontal()
	 * arg1: El tamaño de la barra, en esta funcion se comprobara que cumple con
	 * los limites estableciados
	 *
	 * Se encarga de generar la string que se devuelve a main, llamando a 
	 * generarBloqueCaracteres() para crear la barra que se concatena a la 
	 * variable que se devuelve
	 */
	static String generarBarraHorizontal(int arg1) {
		if (arg1<LIMITE_INFERIOR||arg1>LIMITE_SUPERIOR) {
			return "FUERA DE RANGO";
		}
		String returnable=Integer.toString(arg1);
		returnable=returnable.concat("\t");
		returnable=returnable.concat(generarBloqueCaracteres(arg1,CARACTER_BASE));
		return returnable;
	}
	/*Funcion generarBloqueCaracteres()
	 * arg1: El tamaño de la barra 
	 * arg2: El caracter utilizado para representar dicha barra
	 * 
	 *Genera la barra que se utilizará mas tarde por generarBarraHorizontal()
	 */
	static String generarBloqueCaracteres(int arg1, char arg2) {
		String returnable="";
		String a="%"+Math.abs(arg1-1)+"c";
		System.out.printf(a,'|');
		return returnable;
	}
}
