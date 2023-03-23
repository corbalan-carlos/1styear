package a;

public class Utilidades {
	final private static String regexEmail="^[\\w-\\+]+(\\.[\\w-\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	final private static String regexPassword="(?=.*[A-ZÑ])(?=.*[a-zñ])(?=.*\\d)(?=.+[$*-+&!?%]).{8,}";
	final private static String regexIP="((\\d{1,3})\\.){4}";
	final private static String regexDate="((\\d{1,2})/){2}\\d{1,4}";
	public static boolean validarEmail(String arg) {
		if (arg.matches(regexEmail)) return true;
		return false;
	}
	public static boolean validarPasword(String arg) {
		if (arg.matches(regexPassword)) return true;
		return false;
	}
	public static boolean validarIPv4(String arg) {
		if (!arg.matches(arg)) return false;
		arg+=" ";
		int buffer=0;
		String sBuffer="";
		for (int i=0;i<arg.length();i++) {
			if (arg.charAt(i)=='.') {
				buffer=Integer.parseInt(sBuffer);
				if (buffer>255) return false;
				sBuffer="";
				buffer=0;
				continue;
			}
			sBuffer+=arg.substring(i,i+1);
		}
		return true;
	}
	
	public static boolean validarFecha(String arg) {
		if (!arg.matches(regexDate)) return false;
		int counter=0;
		int[] diaMesAño=new int[3];
		StringBuilder sBuffer=new StringBuilder();
		for (char a:arg.toCharArray()) {
			if (a=='/') {
				counter++;
				diaMesAño[counter]=Integer.parseInt(sBuffer.toString());
				sBuffer.delete(0, sBuffer.length());
			}
			sBuffer.append(a);
		}
		if (diaMesAño[1]>12 && diaMesAño[1]<1) return false;
		if (diaMesAño[1]%2==1) {
			if (diaMesAño[0]>31) return false;
		} else if (diaMesAño[0]==2) {
			if (diaMesAño[0]>28) return false;
		} else {
			if (diaMesAño[0]>30) return false;
		}
		return true;
	}
}
