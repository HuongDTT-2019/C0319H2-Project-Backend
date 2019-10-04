package com.codegym.c0319h2.quanlycongty.repository;

import com.codegym.c0319h2.quanlycongty.model.Role;
import com.codegym.c0319h2.quanlycongty.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findRoleByName(RoleName roleName);
}
