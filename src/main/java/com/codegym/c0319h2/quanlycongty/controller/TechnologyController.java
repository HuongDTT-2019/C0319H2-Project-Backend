package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.company.Technology;
import com.codegym.c0319h2.quanlycongty.service.CompanyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@CrossOrigin
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;
    @GetMapping("/manager/list-tech")
    public ResponseEntity<Iterable<Technology>> findAllTech(){
        Iterable<Technology> technologies = technologyService.findAllTech();
        if (technologies==null){
            return new ResponseEntity<Iterable<Technology>>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<Iterable<Technology>>(technologies,HttpStatus.OK);
        }
    }
    @PostMapping("/manager/create-tech")
    public ResponseEntity<Void> createTech(@RequestBody Technology technology){
        System.out.println("Creating department!");
        technologyService.saveTech(technology);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @PutMapping("/manager/update-tech/{id}")
    public ResponseEntity<Technology> updateTech(@PathVariable("id") Long id, Technology technology){
        Optional<Technology> technologyOld = technologyService.findById(id);
        if (!technologyOld.isPresent()){
            return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
        }else {
            technologyOld.get().setName(technology.getName());
            technologyService.saveTech(technologyOld.get());
        }
        return new ResponseEntity<Technology>(technologyOld.get(),HttpStatus.OK);
    }

}
