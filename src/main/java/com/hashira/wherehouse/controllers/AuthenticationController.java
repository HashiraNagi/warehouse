package com.hashira.wherehouse.controllers;

import com.hashira.wherehouse.dto.UserDTO;
import com.hashira.wherehouse.dto.mappers.UserMapper;
import com.hashira.wherehouse.models.User;
import com.hashira.wherehouse.services.CompaniesService;
import com.hashira.wherehouse.services.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private CompaniesService companiesService;
    private UsersService usersService;
    private UserMapper userMapper;

    @Autowired
    public AuthenticationController(CompaniesService companiesService,
                                    UsersService usersService,
                                    UserMapper userMapper){
        this.companiesService = companiesService;
        this.usersService = usersService;
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String authentication(){
        return "authPage";
    }

    @GetMapping("/register")
    public String registrationPage(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "registerPage";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userDTO") UserDTO userDTO){

//        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername(request.getParameter("username"));
//        userDTO.setPassword(request.getParameter("password"));
//        userDTO.setEmail(request.getParameter("email"));
//        userDTO.setCompany(request.getParameter("company_name"));

        User user = userMapper.convertToUser(userDTO);

        //TODO: write validation here

        usersService.save(user);

        return null;
    }

}