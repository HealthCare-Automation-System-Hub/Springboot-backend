package com.health.care.controller;

import com.health.care.model.Contact;
import com.health.care.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact submitContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }
}
