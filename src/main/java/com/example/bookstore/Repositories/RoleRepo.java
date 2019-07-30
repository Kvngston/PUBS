package com.example.bookstore.Repositories;

import com.example.bookstore.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
