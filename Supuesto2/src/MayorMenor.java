/*
 * Carlos Corbalan Andreu
 * 
 * MayorMenor.java
 * 
 *Examen supuesto 2, recibir una serie de numeros y decir cual es 
 *el mayor o el menor de ellos 
 * 
 * 16/11/2022
 */
import java.util.*;
public class MayorMenor {
	static public void main(String args[]) {
		Scanner scanner= new Scanner(System.in);
		int valorEntrada;
		int elMayor=0;
		int elMenor=Integer.MAX_VALUE;
		int contadorDatosValidos=0;
		System.out.print("Teclea números entre 1 y " +Integer.MAX_VALUE+"\n"
				+ "-Cero para terminar-\n");
		while (true) {
			valorEntrada=scanner.nextInt();
			if (valorEntrada<0) continue;
			else if ((valorEntrada==0 && contadorDatosValidos<2)) {
				System.out.print("Se necesitan " + (2-contadorDatosValidos)+" datos mas\n");
				continue;
			} else if (valorEntrada==0) {
				System.out.print("Pulsa 'T/t' para salir\n");
				if (scanner.next().matches("T|t")) break;
				continue;
			}
			if (valorEntrada<elMenor) elMenor=valorEntrada;
			if (valorEntrada>elMayor) elMayor=valorEntrada;
			contadorDatosValidos++;
		}
		System.out.print("Datos finales:\n"
			+ "\tDato Mayor: "+elMayor+"\n"
			+ "\tDato Menor: "+elMenor+"\n"
			+ "\tCantidad de datos validos: "+contadorDatosValidos
		);
		scanner.close();
	}
}
