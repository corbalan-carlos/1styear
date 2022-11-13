import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=0;
		int b=0;
		int c=0;
		while (true) {
			System.out.print("Introduzca un numero\n"
					+ "");
			b=scanner.nextInt();
			if (b<1) break;
			a+=b;
			c++;
		}
		System.out.print("la suma de todos los numeros es:"+a+"\n");
		System.out.print("La media arimetica es:"+(a/c)+"\n");
	}

}
