package com.aynsprojects.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailApplication {

	@Autowired
	private final JavaMailSender emailSender;

	protected MailApplication(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MailApplication.class, args);
		MailApplication mailApplication = context.getBean(MailApplication.class);
		mailApplication.sendMail();
	}

	public void sendMail()  {
		System.out.println("ON ENTRE DANS LA METHODE 'SENDMAIL()'");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("joly.idf@outlook.fr");
		message.setTo("joly.idf@outlook.fr");
		message.setSubject("test sender best mail");
		message.setText("on y arrive !");
		emailSender.send(message);
	}

}
