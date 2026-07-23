package com.elisabetta.taskmanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(
        @RequestParam(required = false) String logout,
        @RequestParam(required = false) String loginSuccess,
        Authentication authentication,
        Model model) {

    if (authentication != null
            && authentication.isAuthenticated()
            && !"anonymousUser".equals(authentication.getName())) {

        model.addAttribute("username", authentication.getName());
    }

    if (loginSuccess != null) {

    model.addAttribute("showWelcome", true);

    }

    if (logout != null) {

        model.addAttribute(
                "successMessage",
                "Hai effettuato il logout con successo.");

    }

        return "index";
    }
}
