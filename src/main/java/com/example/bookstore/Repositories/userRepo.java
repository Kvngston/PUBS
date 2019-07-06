package com.example.bookstore.Repositories;

import com.example.bookstore.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User, Long> {
}
