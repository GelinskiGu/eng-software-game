package com.gelinski.engsoftwaregame.repository;

import com.gelinski.engsoftwaregame.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByDescription(String description);
}