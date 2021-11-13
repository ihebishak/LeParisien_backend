package com.leparisien.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leparisien.services.MailService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/contactUs")
	public String contact(String fullname, String email,String phone, String subject, String comment) throws MessagingException,
			TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {

		Map<String, Object> model = new HashMap<>();
		model.put("FullName", fullname);
		model.put("Email", email);
		model.put("Phone", phone);
		model.put("Subject", subject);
		model.put("Message", comment);

		return mailService.contact(fullname, email,phone, subject, comment, model);
	}

}
