package practica4;

public class Ejercicio8 {
		boolean yaOrdenadoInt(int arr[]) {
			int ref=arr[0];
			if (arr.length==1) return true;
			for (int i=1;i<arr.length-1;i++) {
				if (ref<=arr[i]) {
					ref=arr[i];
				} else {
					return false;
				}
			}
			return true;
		}
}
