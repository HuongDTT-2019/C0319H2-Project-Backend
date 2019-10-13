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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@PropertySource("classpath:application.properties")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Value(value = "${file.upload-dir}")
    private String imgUser;
    @Value(value = "${file.upload-dir-logo}")
    private String imgLogo;
    @Value(value = "${file.upload-dir-avatar}")
   private String imgAvatar;

    @GetMapping(value = "/manager/list-company")
    public ResponseEntity<Iterable<Company>> findAllCompany() {
        Iterable<Company> companies = companyService.findAllCompany();
        if (companies == null) {
            System.out.println("Không có dữ liệu");
            return new ResponseEntity<Iterable<Company>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Iterable<Company>>(companies, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/manager/create-company")
    public ResponseEntity<Company> updateUser(@ModelAttribute CompanyForm companyForm) throws IOException {

        //avatar
        ArrayList<MultipartFile> fileImageCompany = companyForm.getAvatar();
        ArrayList<String> fileName = new ArrayList<>();
        ArrayList<File> saveFiles = new ArrayList<>();
        for (MultipartFile multipartFile : fileImageCompany) {
                fileName.add(multipartFile.getOriginalFilename());
        }
        for(String fileNames:fileName){
            saveFiles.add(new File(imgAvatar+fileNames));
        }
        for (MultipartFile multipartFile : fileImageCompany) {
            for (File saveFile: saveFiles){
                try {
                    FileCopyUtils.copy(multipartFile.getBytes(), saveFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }


        //logo
        MultipartFile multipartFileLogo = companyForm.getLogo();
        String fileNameLogo = multipartFileLogo.getOriginalFilename();
        assert fileNameLogo != null;
        File uploadedFileLogo = new File(imgLogo, fileNameLogo);

        try {
            FileCopyUtils.copy(multipartFileLogo.getBytes(), uploadedFileLogo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Company company = new Company(companyForm.getName(), companyForm.getShortname(), companyForm.getAddress()
                , companyForm.getPhonenumber(), companyForm.getEmail(), fileNameLogo, fileName
                , companyForm.getRelationship(), companyForm.getSpecialize(), companyForm.getLanguage(), companyForm.getTechnology(), companyForm.getMarket());
        companyService.saveCompany(company);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }
}
