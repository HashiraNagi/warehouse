package com.hashira.wherehouse.services;

import com.hashira.wherehouse.models.User;
import com.hashira.wherehouse.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    @Transactional
    public void saveOrUpdate(User user){
        usersRepository.save(user);
    }

    public Optional<User> findByUsername(String username){
        return usersRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email){
        return usersRepository.findByEmail(email);
    }

}
