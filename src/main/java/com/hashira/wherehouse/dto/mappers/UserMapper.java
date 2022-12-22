package com.hashira.wherehouse.dto.mappers;

import com.hashira.wherehouse.dto.UserDTO;
import com.hashira.wherehouse.models.User;
import com.hashira.wherehouse.services.CompaniesService;
import com.hashira.wherehouse.services.UsersService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private CompaniesService companiesService;

    public UserMapper(CompaniesService companiesService){
        this.companiesService = companiesService;
    }

    public User convertToUser(UserDTO userDTO){
        User user = new User();
        user.setPassword(userDTO.getPassword());
        userDTO.setPassword(null);
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setCompany(companiesService.findByName(userDTO.getCompany()));
        userDTO = null;
        return user;
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(null);
        userDTO.setEmail(user.getEmail());
        userDTO.setCompany(user.getCompany().getName());
        return userDTO;
    }
}
