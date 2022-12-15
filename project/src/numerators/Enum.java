package numerators;

public class Enum {
	enum A {
		B(2) {
			String b="a";
		},
		C(1);
		int a;
		A (int a) {
			this.a=a;
		}
	}
	public static void main(String args[]) {
		System.out.print(A.B.b+"\n");
		System.out.print(A.C.a+"\n");
		//System.out.print);
	}
}
