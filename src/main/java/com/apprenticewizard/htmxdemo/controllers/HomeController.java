package com.apprenticewizard.htmxdemo.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping
    public String home(CsrfToken csrfToken, Model  model) {
        model.addAttribute("_csrf", csrfToken);
        return "index";
    }
}
