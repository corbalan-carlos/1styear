package grupo.aplicacion;


public class Session {
	User user;
	boolean logged;
	Session() {
		this.logged=false;
		this.user=null;
	}
	boolean login() {
		
	}
	User signup() {
		
	}
	void showUser() {
		
	}
	void logout() {
		user=null;
		logged=false;
	}
	
}
