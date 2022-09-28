import java.util.*;
public class Nombre1 {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Dame el nombre y la edad de la primera persona\n");
		String a=teclado.nextLine();
		System.out.print("Dame el nombre y la edad de la segunda persona\n");
		a+="\n"+teclado.nextLine();
		System.out.print(a);
		teclado.close();
	}
}
