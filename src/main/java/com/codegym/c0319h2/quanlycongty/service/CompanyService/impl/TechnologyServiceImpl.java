package com.codegym.c0319h2.quanlycongty.service.CompanyService.impl;

import com.codegym.c0319h2.quanlycongty.model.company.Technology;
import com.codegym.c0319h2.quanlycongty.repository.TechnologyRepository;
import com.codegym.c0319h2.quanlycongty.service.CompanyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public void saveTech(Technology technology) {
        technologyRepository.save(technology);
    }

    @Override
    public void editTech(Technology technology) {
        technologyRepository.save(technology);
    }

    @Override
    public Optional<Technology> findById(Long id) {
        return technologyRepository.findById(id);
    }

    @Override
    public void removeTech(Technology technology) {
        technologyRepository.delete(technology);
    }

    @Override
    public Iterable<Technology> findAllTech() {
        return technologyRepository.findAll();
    }
}
