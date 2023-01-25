/*
 * Carlos Corbalan Andreu
 * 
 * Creado 24/1/23
 * 
 * Contiene informacion sobre el sistema anfitrion y 
 * mantiene info sobre otros SOs
 * 
 */
package grupo.aplicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class SystemProperties {
	/*
	 * enum:
	 * 	Utilidad: Tenere una lista de informacion pertinente sobre los posibles SO
	 * 	sobre los que se puede la aplicacion
	 */
	public enum SystemPropertiesList { 
		WINDOWS("\r\n","\\","Windows"),
		LINUX("\n","/","Linux"),
		SUNOS("\n","/","SunOS"),
		FREEBSD("\n","/","FreeBSD"),
		MACOSX("\n","/","Mac OS X"),
		OTHER("null","null","Other");
		/*lineDelimitator: utilizado para saber que caracteres marcan el 
		 * final de linea
		 */
		public final String lineDelimitator;
		/* fileNameDelimitator: utilizado para sabar que caracter delimita
		 * las rutas del Sistema de archivos
		 */
		public final String fileNameDelimitator;
		/*osName: el nombre del sistema operativo
		 *  Windows tiene una entrada diferente para cada version 
		 *  pero ya que todos menos Windows 98 corren bajo NT no 
		 *  deberia pasar nada si se no se incorpora la version en 
		 *  la string
		 */
		public final String osName;
		/*constructor:
		 * 	Parametros:
		 * 	Utilidad: Inicializar los miembros del enum
		 */
		private SystemPropertiesList(String lineDelimitator,String pathNames,String osName) {
			this.lineDelimitator=lineDelimitator;
			this.fileNameDelimitator=pathNames;
			this.osName=osName;
		}
	}
	/*lineDelimitator: utilizado para saber que caracteres marcan el 
	 * final de linea
	 */
	public String lineDelimitator;
	/* fileNameDelimitator: utilizado para sabar que caracter delimita
	 * las rutas del Sistema de archivos
	 */
	public String fileNameDelimitator;
	/*osName: el nombre del sistema operativo
	 *  
	 */
	public final String osName;
	/* windowsVersion:
	 * Que version de Windows corre el anfitrion
	 * En caso de que no sea windows se pone null 
	 */
	public final String windowsVersion;
	/*encoding:
	 * El objeto de tipo Charset que corresponde a 
	 * la codificacion del sistema
	 */
	public final Charset encoding;
	/*constructor:
	 * Parametros:
	 * Utilidad: Inicializa todas las propiedades del
	 * objeto utilizando la llamada getSystemIdisyncracies()
	 */
	SystemProperties() {
		String osName=System.getProperty("os.name");
		SystemPropertiesList a=getSystemIdiosyncracies(osName);
		this.encoding=Charset.defaultCharset();
		this.lineDelimitator=a.lineDelimitator;
		this.fileNameDelimitator=a.fileNameDelimitator;
		this.osName=osName;
		if (a.osName=="Windows") {
			windowsVersion=System.getProperty("os.name").substring("Windows".length()-1);
		} else {
			windowsVersion=null;
		}
	}
	/*metodo:
	 * Parametros: 
	 * 	String os: El nombre del sistema operativo del
	 * 	cual se busca informacion
	 * Devuelve:
	 * 	SystemPropertiesList: el enumerado correspondiente 
	 *	sistema anfitrion
	 * Utilidad: Devolver el enumerado correspondiente al
	 * sistema que se busca desde os
	 */
	static public SystemPropertiesList getSystemIdiosyncracies(String os) {
		if (os.contains("Windows")) os="Windows";
		switch (os) {
		case "Windows":return SystemPropertiesList.WINDOWS;
		case "Linux":return SystemPropertiesList.LINUX;
		case "SunOS":return SystemPropertiesList.SUNOS;
		case "FreeBSD":return SystemPropertiesList.FREEBSD;
		case "Mac OS X":return SystemPropertiesList.MACOSX;
		default: return SystemPropertiesList.OTHER;
		}
	}
}
