package practica4;

public class Ejercicio10 {
	public static void main(String args[]) {
		int[] arr1 = {1,2,3,4,5,6,7};
		int[] arr2 = {2,3};
		boolean a;
		for (int i=0;i<arr1.length-arr2.length-1;i++) {
			a=true;
			for (int j=0;j<arr2.length;j++) {
				if (arr1[i+j]!=arr2[j]) {
					a=false;
					break;
				}
				
			}
			if (a) {
				System.out.print("Array 2 esta dentro de Array 1");
				break;
			}
		}
		
	}
}
