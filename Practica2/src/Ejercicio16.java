import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		double num;
		double buffer;
		int aprox;
		int counter=0;
		System.out.print("Introduzca un entero\n");
//		System.out.print("Introduzca el numero\n");
		num=scanner.nextInt();
		System.out.print("Se le va a pedir que introduzca uno a uno los digitos decimales del numero\n");
		while (true) {
			System.out.print("Introduzca el numero\n");
			buffer=scanner.nextInt();
			if (buffer<0) {
				System.out.print("Por favor un numero mayor o igual a 0\n");
				continue;
			} else if (buffer>0 ) {
				buffer=(long) (buffer/Math.pow(10,(int) Math.log10(buffer)));
			}
			
			buffer/=(10*Math.pow(10,counter++));
			num+=buffer;
			System.out.print("El numero es "+num+"\n");
			System.out.print("Desa continuar?(Y/N)\n");
			if (scanner.next().matches("N|n")) break;
		}
		System.out.print("A cuantos decimales le gustaria aproximar?\n");
		aprox=scanner.nextInt();
		num*=(Math.pow(10,aprox));
		if ((num*10)%10>5) num+=1;
		num=(int )num;
		num/=Math.pow(10,aprox);
		System.out.print("El valor aproximado es "+num+"\n");
		
	}

}
