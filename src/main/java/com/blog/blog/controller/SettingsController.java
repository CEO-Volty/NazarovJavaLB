package com.blog.blog.controller;

import com.blog.blog.model.UserAc;
import com.blog.blog.service.AccountService;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SettingsController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/settings")
    public String getEditMaterial(Model model) {
        model.addAttribute("userAc", userService.findByUsername(accountService.getUserInfo().getUsername()));
        return "settings";
    }

    @PostMapping("/settings")
    public String postEditMaterial(@ModelAttribute UserAc userAc, Model model, @RequestParam("Action") String action) {
        if(action.equals("save"))
        {
            try {
                userService.updateUser(userAc);

                return "redirect:/settings";
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                return "redirect:/settings";
            }
        }
        if(action.equals("delete"))
        {
            try {

                userService.deleteUser(userAc.getId());
                return "redirect:/Index";
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                return "redirect:/settings";
            }
        }
        return "redirect:/settings";
    }




}
