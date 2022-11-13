import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=0; 
		int decimales=0;
		double buffer;
		int aprox;
		System.out.print("Introduzca un entero\n");
//		System.out.print("Introduzca el numero\n");
		num=scanner.nextInt();
		System.out.print("Se le va a pedir que introduzca uno a uno los digitos decimales del numero\n");
		while (true) {
			System.out.print("Introduzca el numero\n");
			buffer=scanner.nextInt();
			buffer=buffer/Math.pow(10,(int) Math.log10(buffer));
			decimales*=10;
			decimales+=buffer;
			System.out.print("El numero es "+num+"."+decimales+"\n");
			System.out.print("Desa continuar?(Y/N)\n");
			if (scanner.next().matches("N|n")) break;
		}
		System.out.print("A cuantos decimales te gustaria aprozimar?");
		aprox=scanner.nextInt();
		int a=decimales/(int) Math.pow(10, aprox);
		System.out.print(a);
		}

}
