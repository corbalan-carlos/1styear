import java.util.Scanner;

public class Ejercicio6 {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Este programa muestra la tabla de multiplicar"
				+ " de cualquier numero pasado "
				+ "\nDame un numero: ");
		calcularMostrarTabla(teclado.nextInt());
	}
	static void calcularMostrarTabla(int numero)  {
		for (int i=0;i<16;i++) {
			System.out.print(i+"\t"+(i*numero)+"\n"
					+ "");
		}
	}
}
