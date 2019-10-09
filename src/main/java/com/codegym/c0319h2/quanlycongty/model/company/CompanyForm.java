package com.codegym.c0319h2.quanlycongty.model.company;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class CompanyForm {
    private Long id;
    private String name;
    private String shortname;
    private String address;
    private int phonenumber;
    private String email;
    private MultipartFile logo;
    private String information;
    private MultipartFile imageCompany;
    private String relationship;
    private String specialize;
    private String language;
    private String technology;
    private String market;
    public CompanyForm(){
    }

    public CompanyForm(String name, String shortname, String address, int phonenumber, String email, MultipartFile logo, String information, MultipartFile imageCompany, String relationship, String specialize, String language, String technology, String market) {
        this.name = name;
        this.shortname = shortname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.logo = logo;
        this.information = information;
        this.imageCompany = imageCompany;
        this.relationship = relationship;
        this.specialize = specialize;
        this.language = language;
        this.technology = technology;
        this.market = market;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public MultipartFile getImageCompany() {
        return imageCompany;
    }

    public void setImageCompany(MultipartFile imageCompany) {
        this.imageCompany = imageCompany;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Technology> getTechnology() {
        List<Technology> lstOutput = null;
        ObjectMapper om = new ObjectMapper();
        JavaType type =  om.getTypeFactory().constructCollectionType(List.class, Technology.class);
        try {
            lstOutput = om.readValue(this.technology,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstOutput;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
