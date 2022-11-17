package MtThreading;

public class Main {
		static public void main(String args[]) {
			MyClass a=new MyClass();
			Thread b=new Thread(a);
			System.out.print("Thread 1 "+Thread.currentThread().getId()+"\n");
			System.out.print("Thread 2 "+b.getId()+"\n");
			b.start();
			System.out.print("hello\n");
			try {
				Thread.sleep(100 );
			} catch (Exception E) {
				System.out.print(E.getMessage());
			}
			synchronized (a) {
				System.out.print("Thread 3 "+Thread.currentThread().getId()+"\n");
				try {
					Thread.sleep(5000);
				} catch (Exception E) {
					System.out.print(E.getMessage());
				}
				System.out.print("im back\n");
			}
			System.out.print("bye\n");
		}
}
