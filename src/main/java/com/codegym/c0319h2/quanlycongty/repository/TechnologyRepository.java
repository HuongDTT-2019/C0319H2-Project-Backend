package com.codegym.c0319h2.quanlycongty.repository;

import com.codegym.c0319h2.quanlycongty.model.company.Technology;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends PagingAndSortingRepository<Technology, Long> {
}
