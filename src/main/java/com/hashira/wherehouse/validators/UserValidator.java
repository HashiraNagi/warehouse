package com.hashira.wherehouse.validators;

import com.hashira.wherehouse.models.User;
import com.hashira.wherehouse.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private UsersService usersService;

    @Autowired
    public UserValidator(UsersService usersService){
        this.usersService = usersService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(usersService.findByUsername(user.getUsername()).isPresent()){
            errors.rejectValue("username", "", "This username is already taken");
        }

        if(usersService.findByEmail(user.getEmail()).isPresent()){
            errors.rejectValue("email", "", "This email is already taken");
        }

    }
}
