package practico5;
import java.util.Stack;

public class Principal {

	public static void main(String[] args) {
		Dispositivo[] arr=importarDispositivos("%aa:bb:cc:dd:ee:ff%estas%34<>estas%como%hola%43");
		mostrarDispositivos(arr);
	}
	static Dispositivo[] importarDispositivos(String arg) {
		StringBuilder buffer=new StringBuilder();
		Dispositivo bufferD=new Dispositivo();
		boolean a=false;
		int counter=0;
		Stack<Dispositivo> lifo=new Stack<>();
		for (char i:arg.toCharArray()) {
			if (i=='<') {
				a=true;
				continue;
			}
			if (i=='>'&&a) {
				bufferD.precio=Integer.parseInt(buffer.toString());
				buffer=new StringBuilder();
				lifo.push(bufferD);
				bufferD=new Dispositivo();
				counter=0;
				continue;
			}
			if (i=='%') {
				switch (counter) {
					case 0:  bufferD.marca=buffer.toString();
					counter++;
					buffer=new StringBuilder();
					continue;
					case 1: bufferD.mac=buffer.toString();
					counter++;
					buffer=new StringBuilder();
					continue;
					case 2: bufferD.modelo=buffer.toString();
					counter++;
					buffer=new StringBuilder();
					continue;
				}
				
			}
			buffer.append(i);
		}
		bufferD.precio=Integer.parseInt(buffer.toString());
		lifo.push(bufferD);
		Dispositivo[] arr=new Dispositivo[lifo.size()+4];
		for (int i=0;i<arr.length;i++) {
			if (lifo.size()==0) break;
			arr[i]=lifo.pop();
		}
		return arr;
	}
	static void mostrarDispositivos(Dispositivo[] arg) {
		int counter=1;
		for (Dispositivo a:arg) {
			if (a==null) return;
			System.out.print("Dispositivo "+counter+++"\n");
			System.out.print("-------------\n");
			System.out.print("Marca:" + a.marca+"\t");
			System.out.print("MAC:" + a.mac);
			if (!validarFormatoMAC(a.mac)) {
				System.out.print(" (MAC no valida)\t");
			} else {
				System.out.print("\t");
			}
			System.out.print("Modelo:"+ a.modelo+"\t");
			System.out.print("Precio:"+ a.precio+"\n\n");
		}
	}
	static boolean validarFormatoMAC(String a) {
		if (!a.matches("([0-9a-fA-F]{2}:){5}[0-9a-f-A-F]{2}")) return false;
		return true;
	}
}
