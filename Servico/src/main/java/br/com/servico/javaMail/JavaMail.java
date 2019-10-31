package br.com.servico.javaMail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.servico.domain.Login;

public class JavaMail {

	public void enviarEmail(Login login) {
		Properties props = new Properties();

		final String remetente = "study.fatecourinhos@gmail.com";
		final String assunto ="Recuperação de Senha Study+" ;
		
		String msg ="Olá\n"
				+ "Foi solicitado o envio da sua senha do aplicativo Study+.\n"
				+ "------------------------------------------------------\n"
				+ "Senha: " + login.getSenha() +"\n"
				+ "------------------------------------------------------\n";

		props.put("mail.smtp.user", remetente);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");


		JavaMailAuthenticator authenticator = new JavaMailAuthenticator();
		//Session session = Session.getDefaultInstance(props, authenticator);

		//session.setDebug(true);

		try {
			Message message = new MimeMessage(Session.getDefaultInstance(props, authenticator));
			message.setFrom(new InternetAddress(remetente));
			Address[] toUser = InternetAddress.parse(login.getEmail());
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText(msg);
			Transport.send(message);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
