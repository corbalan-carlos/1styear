package Practica4;
public class Ejercicio9 {
	int masFrecuenteInt(int arr[]) {
		if (arr.length==1) return  arr[0]; 
		Pair<Integer,Integer> mainCounter=new Pair<>(arr[0],1);
		int counter;
		for (int i=1;i<arr.length-1;i++) {
			counter=0;
			for (int j=i;j<arr.length-1;j++) {
				if (arr[j]==arr[i]) counter++;
			}
			if (counter>mainCounter.b) {
				mainCounter.a=arr[i];
				mainCounter.b=counter;
			}
		}
		return mainCounter.a;
	}
	class Pair<T,T1> {
		T a;
		T1 b;
		Pair (T a,T1 b) {
			this.a=a;
			this.b=b;
		}
	}
}
