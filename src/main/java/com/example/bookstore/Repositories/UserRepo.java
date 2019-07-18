package com.example.bookstore.Repositories;

import com.example.bookstore.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
