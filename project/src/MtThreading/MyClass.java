package MtThreading;
public class MyClass implements Runnable {
	public void run() {
		int number=100000,counter=3;
	//	System.out.print(System.currentTimeMillis()+"\n");
		switch (number) {
			case 1: System.out.print("0\n");
					counter=0;
					break;
			case 2: System.out.println("2");
					counter=1;
					break;
			case 3: System.out.println("2\n3");
					counter=2;
					break;
			case 4: System.out.println("2\n3");
					counter=2;
					break;
			case 5: System.out.println("2\n3\n\5");
					counter=3;
					break;
			default: System.out.println("2\n3\n5");
		}
		for (int i=7;i<=number;i+=2) {
			if (i%5==0) continue;
			for (int j=3;j<=i;j+=2) {
				if (i/j==1&&i%j==0) {
					//System.out.print(;
					counter++;
					
					break;
				}
				if (i%j==0) break;
			/*	if (i/3==j) {
					System.out.print(i+"\n");
					counter++;
					break;
				}*/
			}
		}
		System.out.print(counter+"\n");
	//	System.out.print(System.currentTimeMillis()+"");
	}
}
