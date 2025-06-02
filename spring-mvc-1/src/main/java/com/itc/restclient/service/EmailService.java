package com.itc.restclient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
/*
	@Autowired
	JavaMailSender javaMailSender;
	
	
	public void sendPlainTextMail(String fromemail, String toemail, String mailsubject, String mailbody) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromemail);
		message.setTo(toemail);
		message.setSubject(mailsubject);
		message.setText(mailbody);
		javaMailSender.send(message);
	}
	public void sendHtmlMail(String fromemail, String toemail, String subject, String mailbody) throws MessagingException
	{
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setFrom(fromemail);
		helper.setTo(toemail);
		helper.setSubject(subject);
		helper.setText(mailbody, true);
		javaMailSender.send(message);
		
	}
	
	*/
}
