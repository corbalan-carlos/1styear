package supuesto4;
import java.util.Scanner;
public class Principal {
	static int CANTIDAD=4;
	static Scanner input=new Scanner(System.in);
	public static void main(String args[]) {
		Cliente[] clientes=pedirClientes();
		clientes=ordenarClientes(clientes);
		for (int i=0;i<CANTIDAD;i++) {
			System.out.print(i+1+": "+clientes[i].nombre+" "+clientes[i].apellidos+"\n");
		}
		System.out.print("Seleccione un cliente: ");
		mostrarCliente(clientes,input.nextInt()-1);
		return;
	}
	static Cliente[] pedirClientes()  {
		Cliente[] arr=new Cliente[4];
		for (int i=0;i<CANTIDAD;i++) {
			arr[i]=new Cliente(
					readString(Cliente.PEDIRNOMBRE),
					readString(Cliente.PEDIRAPELLIDOS),
					readString(Cliente.PEDIREMAIL)
					);
		}
		return arr;
	}
	static String readString(String a) {
		System.out.print(a+"\n");
		input.useDelimiter("\n");
		return input.next();
	}
	static Cliente[] ordenarClientes(Cliente a[]) {
		Cliente buffer;
		for (int i=0;i<a.length-1;i++) {
			for (int j=i;j<a.length-1;j++) {
				if (a[j].apellidos.compareToIgnoreCase(a[i].apellidos)<0) {
					buffer=a[i];
					a[i]=a[j];
					a[j]=buffer;
				}
			}
		}
		return a;
	}
	static void mostrarCliente(Cliente[] a, int b) {
		System.out.print("Nombre: "+a[b].nombre+"\n");
		System.out.print("Apellidos: "+a[b].apellidos+"\n");
		System.out.print("email: "+a[b].email+"\n");
		
	}
} 
