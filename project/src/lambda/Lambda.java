package lambda;

public class Lambda {

	public static void main(String[] args) {
		Lambda a=new Lambda();
		a.intento(a::cosa);
	}
	void intento(Intento a) {
		a.doThing();
	}
	void cosa() {
		System.out.print("b");
	}
}
