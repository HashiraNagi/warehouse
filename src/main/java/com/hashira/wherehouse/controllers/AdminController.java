package com.hashira.wherehouse.controllers;

import com.hashira.wherehouse.services.CompaniesService;
import com.hashira.wherehouse.utils.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserUtil userUtil;
    private CompaniesService companiesService;

    public AdminController(UserUtil userUtil,
                           CompaniesService companiesService){
        this.userUtil = userUtil;
        this.companiesService = companiesService;
    }

    @GetMapping("/main")
    public String adminMainPage(Model model){
        model.addAttribute("user",userUtil.getUserFromPrincipal());
        model.addAttribute("companies", companiesService.findAll());
        return "admin/mainPage";
    }

    @GetMapping("/company/{name}")
    public String companyPage(Model model, @PathVariable("name") String name){
        model.addAttribute("company",companiesService.findByName(name));
        return "admin/companyPage";
    }
}
