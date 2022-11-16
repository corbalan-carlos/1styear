import java.util.*;
public class Ejercicio20 {
	static public void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		while (true) {
			System.out.print("1.Sumar\n2.Restar\n3.Multiplicar\n");
			switch (scanner.nextInt()) {
				case 1:	System.out.print(scanner.nextInt()+scanner.nextInt()+"\n");
						break;
				case 2:	System.out.print(scanner.nextInt()-scanner.nextInt()+"\n");
						break;
				case 3: System.out.print(scanner.nextInt()*scanner.nextInt()+"\n");
						break;
				default: continue;
			}
			System.out.print("Desea salir? (Y)\n");
			if (scanner.next().matches("Y|y")) break;
		}
		scanner.close();
	}
}
