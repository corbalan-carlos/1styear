import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		double Cf;
		double Ci;
		double r;
		double n;
		System.out.print("Necesito el capital inicial, el interes y el numero de años en ese orden");
		Ci=scanner.nextDouble();
		r=scanner.nextDouble();
		n=scanner.nextDouble();
		Cf=Ci*Math.pow((1+r),n);
		System.out.print("El capital final es:"+Cf);
		scanner.close();
	}

}
