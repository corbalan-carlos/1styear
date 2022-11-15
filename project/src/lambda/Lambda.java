package lambda;

public class Lambda {

	public static void main(String[] args) {
		Lambda a=new Lambda();
		a.intento(()->{System.out.print("a"); });
	}
	void intento(Intento a) {
		a.doThing();
	}
	void cosa() {
		System.out.print("b");
	}
}
