package com.hashira.wherehouse.repositories;

import com.hashira.wherehouse.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Integer> {
}
