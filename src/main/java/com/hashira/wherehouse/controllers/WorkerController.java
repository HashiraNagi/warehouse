package com.hashira.wherehouse.controllers;

import com.hashira.wherehouse.models.User;
import com.hashira.wherehouse.repositories.UsersRepository;
import com.hashira.wherehouse.services.CompaniesService;
import com.hashira.wherehouse.services.ItemsService;
import com.hashira.wherehouse.services.UsersService;
import com.hashira.wherehouse.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkerController {

    private UsersService usersService;
    private UserUtil userUtil;
    private CompaniesService companiesService;
    private ItemsService itemsService;


    @Autowired
    public WorkerController(UsersService usersService,
                            UserUtil userUtil,
                            CompaniesService companiesService,
                            ItemsService itemsService) {

        this.usersService = usersService;
        this.userUtil = userUtil;
        this.companiesService = companiesService;
        this.itemsService = itemsService;

    }

    @GetMapping("/")
    public String redirectPage(){
        if(true){
            return "";
        }
        else if(false){
            return "";
        }
        else {
            return "";
        }
    }

    @GetMapping("/companyItems")
    public String companyItemsPage(Model model){
        User user = userUtil.getUserFromPrincipal();
        model.addAttribute("user",user);
        return "companyItems";
    }


    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @GetMapping("/err")
    @ResponseBody
    public String err(){
        return "err";
    }

}
