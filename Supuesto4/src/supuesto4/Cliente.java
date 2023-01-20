package supuesto4;

public class Cliente {
	final public static String PEDIRNOMBRE="Dame el nombre:";
	final public static String PEDIRAPELLIDOS="Dame los apellidos:";
	final public static String PEDIREMAIL="Dame el email:";
	public String nombre;
	public String apellidos;
	public String email;
	Cliente (String a,String b, String c){
		this.nombre=a;
		this.apellidos=b;
		this.email=c;
	}
}
