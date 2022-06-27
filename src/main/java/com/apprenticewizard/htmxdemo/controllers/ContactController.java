package com.apprenticewizard.htmxdemo.controllers;


import com.apprenticewizard.htmxdemo.entities.Contact;
import com.apprenticewizard.htmxdemo.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping()
    public String create(@Valid Contact contact, Model model, HttpServletResponse response) {
        contactRepository.save(contact);
        model.addAttribute("contact", contact);
        response.addHeader("HX-Trigger", "newContact");
        return "contact";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts";
    }

}
