
public class Ejercicio13 {
	static double discriminante;
	enum Resultado {
		DEGENARADA (0),
		DGT0 (2),
		DE0(1),
		DLT0 (0);
		int nDeRespuestas;
		Resultado(int a) {
			this.nDeRespuestas=a;
		}
	}
	public static void main(String[] args) {
		

	}
	static Resultado evaluarDiscriminante(double a,double b, double c) {
		if (a==0) return Resultado.DEGENARADA;
		discriminante=Math.pow(b, 2)-4*a*c;
		switch  ((int) discriminante) {
			case 0: return Resultado.DE0;
					break;
			case 
		}
	}

}
