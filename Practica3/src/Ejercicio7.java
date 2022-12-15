import java.util.Scanner;

public class Ejercicio7 {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Este programa muestra el factorial de un numero\n"
						+"Dame un numero: ");
		factorial(teclado.nextInt());
	}
	static void factorial(int a) {
		int b=1;
		for (int i=0;i<a;i++) {
			b*=(i+1);
		}
		System.out.print(b);
	}
}
