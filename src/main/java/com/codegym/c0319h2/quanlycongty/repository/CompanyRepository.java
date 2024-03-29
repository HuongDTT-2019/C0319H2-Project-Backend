package com.codegym.c0319h2.quanlycongty.repository;

import com.codegym.c0319h2.quanlycongty.model.company.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
