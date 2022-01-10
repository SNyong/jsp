package action;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
	
	public GoogleAuthentication() {
		passAuth= new PasswordAuthentication("dnjsah1234@gmail.com", "ahmrychvflxgxdmk");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
