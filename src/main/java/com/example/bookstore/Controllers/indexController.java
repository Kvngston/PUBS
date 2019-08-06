package com.example.bookstore.Controllers;

import com.example.bookstore.Domain.User;
import com.example.bookstore.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class indexController {

    @Autowired
    private UserRepo userRepo;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(){

        return "index2";
    }

    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String getProfilePage(Principal principal, Model model){

        User user = userRepo.findByUserName(principal.getName());
        model.addAttribute("user", user);

        return "myProfile";
    }


}
