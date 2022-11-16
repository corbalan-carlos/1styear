package MtThreading;

public class Main {
		static public void main(String args[]) {
			MyClass a=new MyClass();
			new Thread(a).start();
			System.out.print("hello\n");
			synchronized (a) {
				a.run();
			}
			
		}
}
