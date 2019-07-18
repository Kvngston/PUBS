package com.example.bookstore.Service;

import com.example.bookstore.Domain.User;
import com.example.bookstore.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username);
        CustomUserDetails customUserDetails = null;

        if(user != null){
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
        }else {
            throw  new UsernameNotFoundException("user with Username " + username + "does not exist");
        }
        return customUserDetails;
    }
}
