package com.shopapp.SpringbootappShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AccessDeniedController {

    @GetMapping("/accessDenied")
    public String accessDenied(HttpServletRequest request, Model model) {
        return "accessDenied";
    }
}