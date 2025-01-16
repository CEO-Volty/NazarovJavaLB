package com.blog.blog.controller;

import com.blog.blog.model.UserAc;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/Index")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        return "Index";
    }




    @PostMapping("/Index")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        UserAc userAc = userService.findByUsername(username);

        if (userAc == null) {
            model.addAttribute("error", "Пользователь не найден");
            return "Index";
        }



        if (!userAc.getPassword().equals(password)) {
            model.addAttribute("error", "Неверный пароль");
            return "Index";
        }


        return "main";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userAc", new UserAc());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser (@ModelAttribute UserAc userAc, Model model) {
        try {
            userService.registerUser (userAc);
            return "main";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
