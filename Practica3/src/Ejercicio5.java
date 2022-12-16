import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String args[]) {
		Scanner teclado=new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Numero de horas trabajadas, las 35 primeras se cobran a 15€\n"
					+ "pasadas las 35, la hora se cobra a 22€\n"
					+ "Para salir escribe cualquier caracter que no sea un numero");
				System.out.print(calcularSalario(teclado.nextInt())+"\n");
			} catch (Exception E) {
				break;
			}
			
		}
		teclado.close();
		
	}
	static int calcularSalario(int horas) {
		int returnable=0;
		int i=0;
		for (;i<horas && i <35;i++) {
			returnable+=15;
		}
		for (;i<horas;i++) {
			returnable+=22;
		}
		return returnable;
	}
}
