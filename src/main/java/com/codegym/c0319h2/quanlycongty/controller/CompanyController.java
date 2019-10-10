package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.model.company.CompanyForm;
import com.codegym.c0319h2.quanlycongty.service.CompanyService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import static org.apache.commons.io.FileUtils.getFile;
@RestController
@CrossOrigin
@PropertySource("classpath:application.properties")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Value(value = "${file.upload-imageUser}")
    private String imgUser;
    @Value(value = "${file.upload-imageLogo}")
    private String imgLogo;
    @Value(value = "${file.upload-imageCompany}")
    private String imgCompany;
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
    @PostMapping(value = "/manager/create-company")
    public ResponseEntity<Company> createCompany(@ModelAttribute CompanyForm companyForm) throws IOException {
        //imageCompany
        MultipartFile multipartFileImg = companyForm.getImageCompany();
        String fileNameImg = multipartFileImg.getOriginalFilename();
        File uploadedFile = new File(imgCompany, fileNameImg);

        try {
            FileCopyUtils.copy(multipartFileImg.getBytes(), new File(imgCompany + fileNameImg));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //logo
        MultipartFile multipartFileLogo = companyForm.getLogo();
        String fileNameLogo = multipartFileLogo.getOriginalFilename();
        File uploadedFileLogo = new File(imgLogo, fileNameLogo);

        try {
            FileCopyUtils.copy(multipartFileLogo.getBytes(), new File(imgLogo + fileNameLogo));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Company company = new Company(companyForm.getName(), companyForm.getShortname(), companyForm.getAddress()
                , companyForm.getPhonenumber(), companyForm.getEmail(), fileNameLogo, companyForm.getInformation(), fileNameImg
                , companyForm.getRelationship(), companyForm.getSpecialize(), companyForm.getLanguage(), companyForm.getMarket(), companyForm.getTechnology());
        companyService.saveCompany(company);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }
    @PutMapping("/manager/update-company/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @ModelAttribute CompanyForm companyForm) throws IOException {
        Optional<Company> companyOptional = companyService.findById(id);
        if (!companyOptional.isPresent()){
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        ////////
        //imgCompany
        MultipartFile multipartFileImg = companyForm.getImageCompany();
        String fileNameImg = multipartFileImg.getOriginalFilename();
        File uploadedFile = new File(imgCompany, fileNameImg);

        //imgLogo
        MultipartFile multipartFileLogo = companyForm.getLogo();
        String fileNameLogo = multipartFileLogo.getOriginalFilename();
        File uploadedFileLogo = new File(imgLogo, fileNameLogo);

        if (fileNameImg.isEmpty()){
            fileNameImg = companyOptional.get().getImageCompany();
            companyOptional.get().setImageCompany(fileNameImg);
            companyOptional.get().setName(companyForm.getName());
            companyOptional.get().setShortname(companyForm.getShortname());
            companyOptional.get().setAddress(companyForm.getAddress());
            companyOptional.get().setPhonenumber(companyForm.getPhonenumber());
            companyOptional.get().setEmail(companyForm.getEmail());
            companyOptional.get().setLogo(fileNameLogo);
            companyOptional.get().setInformation(companyForm.getInformation());;
            companyOptional.get().setRelationship(companyForm.getRelationship());
            companyOptional.get().setSpecialize(companyForm.getSpecialize());
            companyOptional.get().setLanguage(companyForm.getLanguage());
            companyOptional.get().setMarket(companyForm.getMarket());
            companyOptional.get().setTechnology(companyForm.getTechnology());
            Company company = companyOptional.get();
            companyService.saveCompany(company);
        }

        if (fileNameLogo.isEmpty()){
            fileNameLogo = companyOptional.get().getLogo();
            companyOptional.get().setImageCompany(fileNameLogo);
            companyOptional.get().setName(companyForm.getName());
            companyOptional.get().setShortname(companyForm.getShortname());
            companyOptional.get().setAddress(companyForm.getAddress());
            companyOptional.get().setPhonenumber(companyForm.getPhonenumber());
            companyOptional.get().setEmail(companyForm.getEmail());
            companyOptional.get().setImageCompany(fileNameImg);
            companyOptional.get().setInformation(companyForm.getInformation());;
            companyOptional.get().setRelationship(companyForm.getRelationship());
            companyOptional.get().setSpecialize(companyForm.getSpecialize());
            companyOptional.get().setLanguage(companyForm.getLanguage());
            companyOptional.get().setMarket(companyForm.getMarket());
            companyOptional.get().setTechnology(companyForm.getTechnology());
            Company company = companyOptional.get();
            companyService.saveCompany(company);
        }

        ///tìm ảnh công ti
        if (companyOptional.get().getImageCompany()== null){
            //Luu file len serve
            try {
                FileCopyUtils.copy(multipartFileImg.getBytes(), new File(imgCompany + fileNameImg));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            ///////////////////////
        }else {
            //getImg va delete
            String pathFile = imgCompany + companyOptional.get().getImageCompany();
            File file = getFile(pathFile);
            FileUtils.forceDelete(file);
            ////
        }
        //Luu file len serve

        try {
            FileCopyUtils.copy(multipartFileImg.getBytes(), new File(imgCompany + fileNameImg));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ///////////////////////

        ///tìm ảnh logo
        if (companyOptional.get().getLogo()== null){
            //Luu file len serve
            try {
                FileCopyUtils.copy(multipartFileLogo.getBytes(), new File(imgLogo + fileNameLogo));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            ///////////////////////
        }else {
            //getImg va delete
            String pathFile = imgLogo + companyOptional.get().getLogo();
            File file = getFile(pathFile);
            FileUtils.forceDelete(file);
            ////
        }
        //Luu file len serve

        try {
            FileCopyUtils.copy(multipartFileLogo.getBytes(), new File(imgLogo + fileNameLogo));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        companyOptional.get().setImageCompany(fileNameImg);
        companyOptional.get().setName(companyForm.getName());
        companyOptional.get().setShortname(companyForm.getShortname());
        companyOptional.get().setAddress(companyForm.getAddress());
        companyOptional.get().setPhonenumber(companyForm.getPhonenumber());
        companyOptional.get().setEmail(companyForm.getEmail());
        companyOptional.get().setLogo(fileNameLogo);
        companyOptional.get().setInformation(companyForm.getInformation());;
        companyOptional.get().setRelationship(companyForm.getRelationship());
        companyOptional.get().setSpecialize(companyForm.getSpecialize());
        companyOptional.get().setLanguage(companyForm.getLanguage());
        companyOptional.get().setMarket(companyForm.getMarket());
        companyOptional.get().setTechnology(companyForm.getTechnology());
        Company company = companyOptional.get();
        companyService.saveCompany(company);
        return new ResponseEntity<Company>(company , HttpStatus.OK);
    }

}
