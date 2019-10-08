package com.codegym.c0319h2.quanlycongty.model;

import org.springframework.web.multipart.MultipartFile;

public class CompanyForm {
    private Long id;
    private String name;
    private String shortname;
    private String address;
    private int phonenumber;
    private String email;
    private MultipartFile logo;
    private MultipartFile avatar;
    private String relationship;
    private String specialize;
    private String language;
    private String technology;
    private String market;
    public CompanyForm(){

    }

    public CompanyForm(String name, String shortname, String address, int phonenumber, String email, MultipartFile logo, MultipartFile avatar, String relationship, String specialize, String language, String technology, String market) {
        this.name = name;
        this.shortname = shortname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.logo = logo;
        this.avatar = avatar;
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

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
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

    public String getTechnology() {
        return technology;
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
