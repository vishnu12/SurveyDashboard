package com.project.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dashboard.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findRoleByName(String name);
}
