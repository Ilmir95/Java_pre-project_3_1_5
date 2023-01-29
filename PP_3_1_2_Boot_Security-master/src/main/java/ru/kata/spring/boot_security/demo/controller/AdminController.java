package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Secured("ADMIN")
    @GetMapping
    public String findAll() {
        return "admin/admin";
    }
}
