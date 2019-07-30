package com.example.bookstore.Controllers;

import com.example.bookstore.Domain.User;
import com.example.bookstore.Repositories.RoleRepo;
import com.example.bookstore.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") @Valid User user,
                               BindingResult result,
                               Model model){




        return "homepage";
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute("user") @Valid User user,
                                BindingResult bindingResult,
                                @RequestParam("cpassword") String cpassword,
                                Model model){

        if(!bindingResult.hasErrors()){
            if (user.getPassword().equals(cpassword)){
                user.setRole(roleRepo.getOne(1));
                userRepo.save(user);
            }
        }


        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "myAccount";
    }
}
