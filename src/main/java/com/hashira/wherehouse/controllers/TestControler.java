package com.hashira.wherehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControler {

    @GetMapping("/test/jsp")
    public String qwe(Model model){

        return "test.jsp";
    }
}
