import java.util.Scanner;

public class TresUsuarios {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		String a="";
		
		for (int i=0;i<3;i++) {
			System.out.print("Escriba los datos separados mediante tabuladores\n");
			a+=teclado.nextLine()+"\n";
		}
		teclado.close();
		int b=a.length()-1;
		for (int i=a.length()-1;i>=0;i--) {
			if (a.charAt(i)=='\n') {
				System.out.print(a.substring(i,b));
				b=i;
			} else if (i==0) {
				System.out.print('\n'+a.substring(i,b));
			}
		}
	}
}
