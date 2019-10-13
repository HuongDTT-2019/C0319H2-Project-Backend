package com.codegym.c0319h2.quanlycongty.service.CompanyService.impl;

import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.repository.CompanyRepository;
import com.codegym.c0319h2.quanlycongty.service.CompanyService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void editCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void removeCompany(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public Iterable<Company> findAllCompany() {
        return companyRepository.findAll();
    }
}
