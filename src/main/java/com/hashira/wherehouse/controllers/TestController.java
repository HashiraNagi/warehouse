package com.hashira.wherehouse.controllers;

import com.hashira.wherehouse.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    UserUtil userUtil;

    @GetMapping("/test/jsp")
    public String qwe(Model model){

        return "test.jsp";
    }

    @GetMapping("/test/thyme")
    public String thyme(Model model){
//        userUtil.getUserFromPrincipal().get
        model.addAttribute("user",userUtil.getUserFromPrincipal());
        return "test";
    }
}
