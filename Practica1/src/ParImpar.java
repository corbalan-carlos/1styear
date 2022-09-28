import java.util.Scanner;
public class ParImpar {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Dame el numero\n");
		int b;
		while (true) {
			b=teclado.nextInt();
			if (b!=0) break;
			
		}
		String a=(b%2==0)?"par":"impar";
		System.out.print("El numero "+b+" es "+a);
		teclado.close();
	}
}