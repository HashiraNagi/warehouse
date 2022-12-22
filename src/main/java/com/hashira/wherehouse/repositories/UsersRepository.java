package com.hashira.wherehouse.repositories;

import com.hashira.wherehouse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
     Optional<User> findByUsername(String username);

     Optional<User> findByEmail(String email);
}
