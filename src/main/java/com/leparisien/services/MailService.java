package com.leparisien.services;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration config;
	
	public String contact(String fullname, String email,String phone, String subject, String comment, Map<String, Object> model)
			throws MessagingException, TemplateNotFoundException, MalformedTemplateNameException, ParseException,
			IOException, TemplateException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		String mailSubject = subject;
		Template t = config.getTemplate("contact.html");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

		helper.setFrom("");  /* saisir l'email qui va envoyer le mail*/
		helper.setTo(""); /* saisir l'email à laquelle l'email va étre envoyé */
		helper.setSubject(mailSubject);
		helper.setText(html, true);

		mailSender.send(message);
		return "message contact us sent";
	}

}
