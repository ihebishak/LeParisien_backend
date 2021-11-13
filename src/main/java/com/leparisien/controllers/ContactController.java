package com.leparisien.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leparisien.entities.Contact;
import com.leparisien.services.ContactService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveContact")
	public Contact saveContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteContact/{id}")
	void deleteContactById(@PathVariable String id) {
		contactService.deleteContactById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "updateContact/{id}")
	public ResponseEntity<Contact> updateConatct(@PathVariable("id") String id, @RequestBody Contact contact) {
		return contactService.updateContact(id, contact);
	}

	@RequestMapping(value = "contacts", method = RequestMethod.GET)
	public List<Contact> fetchAllContacts() {
		return contactService.getAllContacts();
	}

}
