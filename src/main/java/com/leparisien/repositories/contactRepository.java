package com.leparisien.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leparisien.entities.Contact;

@Repository
public interface contactRepository extends MongoRepository<Contact, String> {


}
