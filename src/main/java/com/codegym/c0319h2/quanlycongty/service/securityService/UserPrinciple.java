package com.codegym.c0319h2.quanlycongty.service.securityService;

import com.codegym.c0319h2.quanlycongty.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
//***
//4
// la lop implements UserDetails(lop cua he thong) va khong duoc spring mvc su dung truc tiep de bao mat
// don gian no la 1 lop dung de lu tru thong tin nguoi dung  ma sau do duoc goi gon trong authentication

public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String address;
    private String userName;
    private String avatar;

    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    @JsonIgnore
    private String passWord;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String userName,
                         String passWord,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.authorities = authorities;
    }

    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}