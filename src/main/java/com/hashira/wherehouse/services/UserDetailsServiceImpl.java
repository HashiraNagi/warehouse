package com.hashira.wherehouse.services;

import com.hashira.wherehouse.models.User;
import com.hashira.wherehouse.repositories.UsersRepository;
import com.hashira.wherehouse.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    UsersRepository usersRepository;

    @Autowired
    UserDetailsServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

        return new UserDetailsImpl(user.get());
    }
}
