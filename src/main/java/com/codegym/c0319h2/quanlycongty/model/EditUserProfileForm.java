package com.codegym.c0319h2.quanlycongty.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EditUserProfileForm {
    private MultipartFile avatar;
    private LocalDate birthdate;

    @Pattern(regexp = "/^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$/")
    private String phonenumber;
    private String address;

    public EditUserProfileForm() {
    }

    public EditUserProfileForm(MultipartFile avatar, LocalDate birthdate, @Pattern(regexp = "/^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$/") String phonenumber, String address) {
        this.avatar = avatar;
        this.birthdate = birthdate;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
