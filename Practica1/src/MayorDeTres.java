import java.util.Scanner;

public class MayorDeTres {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Dame el primer numero\n");
		int a=teclado.nextInt();
		System.out.print("Dame el segundo numero\n");
		int b=teclado.nextInt();
		System.out.print("Dame el tercer numero\n");
		int c=teclado.nextInt();
		if (b>=c && b>=a) {
			a=b;
		} else if (c>b && c>a) {
			a=c;
		}
		System.out.print(a);
		teclado.close();
	}
}
