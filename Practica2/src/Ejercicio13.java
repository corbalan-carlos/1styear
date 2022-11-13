import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=0;
		int b=0;
		while (true) {
			System.out.print("Introduzca un numero\n"
					+ "");
			b=scanner.nextInt();
			if (b>a) a=b;
			System.out.print("Desea seguir (S) ");
			if (!scanner.next().matches("s|S")) break;
		}
		System.out.print("El numero mas grande es:"+a);
	}

}
