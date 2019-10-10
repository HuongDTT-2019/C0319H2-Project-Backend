package com.codegym.c0319h2.quanlycongty.service.CompanyService;

import com.codegym.c0319h2.quanlycongty.model.company.Technology;

import java.util.Optional;

public interface TechnologyService {
    void saveTech(Technology technology);
    void editTech(Technology technology);
    Optional<Technology> findById(Long id);
    void removeTech(Technology technology);
    Iterable<Technology> findAllTech();
}
