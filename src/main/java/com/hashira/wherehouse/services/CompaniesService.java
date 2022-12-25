package com.hashira.wherehouse.services;

import com.hashira.wherehouse.models.Company;
import com.hashira.wherehouse.repositories.CompaniesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CompaniesService {

    CompaniesRepository companiesRepository;

    CompaniesService(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    public Company findByName(String name){
        return companiesRepository.findByName(name);
    }

    public List<Company> findAll(){
        return companiesRepository.findAll();
    }
}
