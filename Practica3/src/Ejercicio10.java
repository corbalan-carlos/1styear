import java.util.Scanner;

public class Ejercicio10 {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dame un numero e imprimere un rombo de caracteres de altura n"
						+"\nDame un numero: ");
		triangulo(teclado.nextInt());
		
	}
	static void triangulo(int a) {
		String b="";
		int mod=a%2;
		for (int i=-a/2;i<0;i++) {
			System.out.printf("%"+(Math.abs(i)+mod)+"s","*");
			System.out.print(b+"\n");
			b+="**";
		}
		if (mod==0) b=b.substring(0,b.length()-2);
		for (int i=0;i<a/2+mod;i++) {
			System.out.printf("%"+(i+1)+"s","*");
			System.out.print(b+"\n");
			if (b.length()==0) return;
			b=b.substring(0,b.length()-2);
		}
	}
}
