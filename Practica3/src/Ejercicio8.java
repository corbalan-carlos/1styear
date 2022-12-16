import java.util.Scanner;

public class Ejercicio8 {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Este programa te devuelve la posicion n de la secuencia de fibonacci\n"
				+ "Dame un numero: ");
		System.out.print(fibonacci(teclado.nextInt()));
	}
	static int fibonacci(int a) {
		if (a<0) return -1;
		int b=0;
		int c=1;
		int aux;
		for (int i=0;i<a;i++) {
			aux=c;
			c+=b;
			b=aux;
		}
		return b;
	}
}
