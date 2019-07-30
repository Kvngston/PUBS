package com.example.bookstore;

import com.example.bookstore.Domain.Role;
import com.example.bookstore.Repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    private RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Role role = new Role();
        role.setRole("User");
        roleRepo.save(role);
        Role role2 = new Role();
        role2.setRole("Admin");
        roleRepo.save(role2);


    }
}
