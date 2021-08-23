package com.frankmoley.lil.designpatternsapp.controller;


import com.frankmoley.lil.designpatternsapp.builder.Contact;
import com.frankmoley.lil.designpatternsapp.factory.Pet;
import com.frankmoley.lil.designpatternsapp.factory.PetFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {

    private final PetFactory petFactory;

    public AppController(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    @GetMapping
    public String getDefault(){
        return "{\"message\": \"Hello World\"}";
    }

    @PostMapping("adopt/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
        final Pet pet = this.petFactory.adoptPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }

    @GetMapping("contacts")
    public List<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact.Builder().setFirstName("Bob").setLastName("Builder").build());
        contacts.add(new Contact.Builder().setFirstName("Sue").setLastName("Builder").build());
        return contacts;
    }
}
