package com.hashira.wherehouse.repositories;

import com.hashira.wherehouse.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Company,Long> {
    public Company findByName(String name);
}
