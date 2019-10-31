package br.com.servico.javaMail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class JavaMailAuthenticator extends Authenticator{

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
	 String username = "study.fatecourinhos@gmail.com";
	 String password = "tcc2019study";
	    if ((username != null) && (username.length() > 0) && (password != null) 
	      && (password.length   () > 0)) {

	        return new PasswordAuthentication(username, password);
	    }

	    return null;
	}
}
