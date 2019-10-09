package com.codegym.c0319h2.quanlycongty.model.company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String shortname;
    private String address;
    private int phonenumber;
    private String email;
    private String logo;
    private String information;
    private String imageCompany;
    private String relationship;
    private String specialize;
    private String language;
    private String market;

    @ManyToMany(targetEntity = Technology.class)
    private List<Technology> technology;
    public Company() {
    }

    public Company(String name, String shortname, String address, int phonenumber, String email, String logo,String information, String imageCompany, String relationship, String specialize, String language, String market, List<Technology> technology) {
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
        this.market = market;
        this.technology = technology;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getImageCompany() {
        return imageCompany;
    }

    public void setImageCompany(String imageCompany) {
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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public List<Technology> getTechnology() {
        return technology;
    }

    public void setTechnology(List<Technology> technology) {
        this.technology = technology;
    }
}
