import java.util.*;
public class Ejercicio19 {
		public static void main(String args[]) {
			double x2,x,number,result1,result2;
			Scanner scanner=new Scanner(System.in);
			System.out.print("Necesito los numeros que conformarian una ecuacion de segundo grado (ax²+bx+c)\n");
			x2=scanner.nextInt();
			x=scanner.nextInt();
			number=scanner.nextInt();
			if (((x*x)-(4*x2*number))<0) {
				System.out.print("La ecuación no tiene soluciones reales");
				scanner.close();
				return;
			}
			result1=(((0-x)+(Math.sqrt((x*x)-(4*x2*number))))/(2*x2));
			result2=(((0-x)-(Math.sqrt((x*x)-(4*x2*number))))/(2*x2));
			System.out.print("Las soluciones son "+result1+" y "+result2);
			scanner.close();
		}
}