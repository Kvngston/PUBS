package com.example.bookstore.Controllers;

import com.example.bookstore.Domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(){

        return "index2";
    }
}
