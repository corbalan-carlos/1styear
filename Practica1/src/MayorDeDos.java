
import java.util.Scanner;
public class MayorDeDos {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Dame el primer numero\n");
		int a=teclado.nextInt();
		System.out.print("Dame el segundo numero\n");
		int b=teclado.nextInt();
		a=(a>b)?a:b;
		System.out.print(a);
		teclado.close();
	}
}