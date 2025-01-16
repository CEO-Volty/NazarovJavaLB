package com.blog.blog.controller;

import com.blog.blog.model.Material;
import com.blog.blog.service.AccountService;
import com.blog.blog.service.MaterialService;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/material")
    public String getAllMaterials(Model model) {
        model.addAttribute("materials", materialService.getMaterialsByUserId(accountService.getUserInfo().getId()));
        return "material";
    }

    @GetMapping("/add_material")
    public String getAddMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "add_material";
    }

    @GetMapping("/edit_material")
    public String getEditMaterial(Model model) {
        return "edit_material";
    }

    @GetMapping("/edit_material/{id}")
    public String getEditMaterial(@PathVariable Long id, Model model) {
        model.addAttribute("material", materialService.getMaterialsById(id));
        return "edit_material";
    }

    @PostMapping("/edit_material")
    public String postEditMaterial(@ModelAttribute Material material, Model model, @RequestParam("Action") String action) {
        if(action.equals("save"))
        {
            try {
                material.setUserAc(accountService.getUserInfo());
                materialService.addMaterial(material);
                return "redirect:/material";
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                return "edit_material";
            }
        }
        if(action.equals("delete"))
        {
            try {
                material.setUserAc(accountService.getUserInfo());
                materialService.delMaterial(material);
                return "redirect:/material";
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                return "edit_material";
            }
        }
        return "edit_material";
    }

    @PostMapping("/add_material")
    public String registerUser (@ModelAttribute Material material, Model model) {
        try {
            material.setUserAc(accountService.getUserInfo());
            materialService.addMaterial(material);
            return "redirect:/material";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "add_material";
        }
    }


}
