package com.example.Mochi.repository;

import com.example.Mochi.entity.Role;
import com.example.Mochi.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(Roles name);
}
