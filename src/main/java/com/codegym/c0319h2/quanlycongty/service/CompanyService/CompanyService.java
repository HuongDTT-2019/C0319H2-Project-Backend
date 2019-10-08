package com.codegym.c0319h2.quanlycongty.service.CompanyService;

import com.codegym.c0319h2.quanlycongty.model.Company;
import com.codegym.c0319h2.quanlycongty.model.User;

import java.util.Optional;

public interface CompanyService {
    void saveCompany(Company company);
    void editCompany(Company company);
    Optional<Company> findById(Long id);
    void removeCompany(Company company);
    Iterable<Company> findAllCompany();
}
