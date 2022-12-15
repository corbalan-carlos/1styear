//import java.util.Formatter;
import java.util.Scanner;

public class Ejercicio12 {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dame un numero e imprimere una piramide de caracteres de altura n"
						+"\nDame un numero: ");
		System.out.print(triangulo(teclado.nextInt()));
		
	}
	static String triangulo(int a) {
		String b="*";
		String c="";
		for (int i=0;i<a;i++) {
			c+=String.format("%"+(a-i+2*i)+"s\n",b);
			b+="**";
		}
		return c;
	}
}
