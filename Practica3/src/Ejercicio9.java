import java.util.Scanner;

public class Ejercicio9 {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dame un numero e imprimere una piramide de caracteres de altura n"
						+"\nDame un numero: ");
		triangulo(teclado.nextInt());
		
	}
	static void triangulo(int a) {
		String b="*";
		for (int i=0;i<a;i++) {
			System.out.printf("%"+(a-i+2*i)+"s\n",b);
			b+="**";
		}
	}
}
