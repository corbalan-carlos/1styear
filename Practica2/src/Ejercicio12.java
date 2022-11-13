import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=0;
		System.out.print("Dame 8 numeros\n");
		for (int i=0;i<8;i++) {
			a+=scanner.nextInt();
		}
		System.out.print("El resultado final es:"+a);
	}

}
