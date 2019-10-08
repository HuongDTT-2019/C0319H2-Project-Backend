package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Company;
import com.codegym.c0319h2.quanlycongty.model.CompanyForm;
import com.codegym.c0319h2.quanlycongty.service.CompanyService.CompanyService;
import com.codegym.c0319h2.quanlycongty.service.CompanyService.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@PropertySource("classpath:application.properties")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Value(value = "${file.upload-dir}")
    private String imgUser;

    @GetMapping(value = "/manager/list-company")
    public ResponseEntity<Iterable<Company>> findAllCompany(){
        Iterable<Company> companies = companyService.findAllCompany();
        if (companies == null){
            System.out.println("Không có dữ liệu");
            return new ResponseEntity<Iterable<Company>>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<Iterable<Company>>(companies, HttpStatus.OK);
        }
    }
    @PostMapping(value = "/manager/create-company", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Company> updateUser(CompanyForm companyForm, @RequestParam("avatar") MultipartFile multipartFileAvt, @RequestParam("logo") MultipartFile multipartFileLogo) throws IOException {

        //avatar
        String fileNameAvt = multipartFileAvt.getOriginalFilename();
        File uploadedFile = new File(imgUser, fileNameAvt);

        try {
            FileCopyUtils.copy(multipartFileAvt.getBytes(), new File(imgUser + fileNameAvt));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //logo
        String fileNameLogo = multipartFileLogo.getOriginalFilename();
        File uploadedFileLogo = new File(imgUser, fileNameLogo);

        try {
            FileCopyUtils.copy(multipartFileLogo.getBytes(), new File(imgUser + fileNameLogo));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        Company company = new Company(companyForm.getName(), companyForm.getShortname(), companyForm.getAddress()
                , companyForm.getPhonenumber(), companyForm.getEmail(), fileNameLogo, fileNameAvt
                , companyForm.getRelationship(), companyForm.getSpecialize(), companyForm.getLanguage(), companyForm.getTechnology(), companyForm.getMarket());
        companyService.saveCompany(company);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }
}
