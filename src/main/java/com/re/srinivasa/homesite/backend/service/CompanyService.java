package com.re.srinivasa.homesite.backend.service;

import com.re.srinivasa.homesite.backend.entity.Company;
import com.re.srinivasa.homesite.backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

}
