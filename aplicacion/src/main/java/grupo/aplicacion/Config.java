/*
 * Carlos Corbalan Andreu
 * 
 * Creado 24/1/23
 * 
 * Contiene variables staticas para ser usadas en el resto de la aplicacion
 * 
 */
package grupo.aplicacion;

public class Config {
	//mazeDir: la string con el pathname de donde se encuetran los assets de los laberintos
	static public String mazeDir="mazes/";
	//userFile: el fichero donde se encuentra la informacion sobre los usuarios
	static public String userFile="users.txt";
	//constSystetmProperties: un objeto de tipo SystemProperties que guarda las ideosincracias del sistema anfitrion
	static public final SystemProperties constSystemProperties=new SystemProperties();
	//currentSystemProperties: un objeto de tipo SystemProperties que guarda informacion sobre el sistema que se puede cambiar y manipular
	public static SystemProperties currentSystemProperties;
	/*constructor:
	 * Paramatros:
	 * 
	 *  Utilidad:
	 * Inicializar currentSystemProperties como las por defecto del sistema operativo 
	 * ademas de parar la ejecucion si es un SO diferente de aquellos
	 * encontrados en SystemPropertiesList 
	 */
	Config() {
		currentSystemProperties=constSystemProperties;
		assert(currentSystemProperties.osName!="Other"): "No se conoce el SO anfitrion";
	}
	/*constructor:
	 * Paramatros:
	 * 	userFile: el valor que se le dara a userFile
	 *  Utilidad:
	 * Inicializar currentSystemProperties como las por defecto del sistema operativo 
	 * ademas de parar la ejecucion si es un SO diferente de aquellos
	 * encontrados en SystemPropertiesList 
	 */
	Config(String userFile) {
		currentSystemProperties=constSystemProperties;
		assert(currentSystemProperties.osName!="Other"): "No se conoce el SO anfitrion";
	}
	/*constructor:
	 * Paramatros:
	 * 	userFile: el valor que se le dara a userFile
	 * 	mazeDir: el valor que se le dara a mazeDir
	 *  Utilidad:
	 * Inicializar currentSystemProperties como las por defecto del sistema operativo 
	 * ademas de parar la ejecucion si es un SO diferente de aquellos
	 * encontrados en SystemPropertiesList 
	 */
	Config(String userFile, String mazeDir) {
		Config.userFile=userFile;
		Config.mazeDir=mazeDir;
		currentSystemProperties=constSystemProperties;
		assert(currentSystemProperties.osName!="Other"): "No se conoce el SO anfitrion";
	}
}
