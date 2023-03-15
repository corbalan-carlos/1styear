package practica4;
import java.util.Scanner;
public class Ejercicio3 {
	static 	Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dame 10 numeros\n");
		int[] arr=new int[10];
		for (int i=0;i<10;i++) arr[i]=input.nextInt();
		input.close();
	}
	private static void frecuenciaNumero(int[] arr) {
		System.out.print("Dame el numero a buscar: ");
		int a=input.nextInt();
		int counter=0;
		for (int i=0;i<10;i++) if (a==i) counter++;
		System.out.print("\n");
		System.out.print(counter);
		return;
	}
}
