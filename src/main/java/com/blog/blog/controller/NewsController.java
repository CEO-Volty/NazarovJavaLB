package com.blog.blog.controller;

import com.blog.blog.model.News;
import com.blog.blog.service.AccountService;
import com.blog.blog.service.NewsService;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class NewsController {
    @Autowired
    private  NewsService newsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/news")
    public String getAllMaterials(Model model) {
        model.addAttribute("newsSet", newsService.getNewsByUserId(accountService.getUserInfo().getId()));
        return "news";
    }

    @GetMapping("/add_news")
    public String getAddMaterial(Model model) {
        model.addAttribute("news", new News());
        return "add_news";
    }

    @GetMapping("/edit_news")
    public String getEditMaterial(Model model) {
        return "edit_news";
    }

    @GetMapping("/edit_news/{id}")
    public String getEditMaterial(@PathVariable Long id, Model model) {
        model.addAttribute("news", newsService.getNewsById(id));
        return "edit_news";
    }

    @PostMapping("/edit_news")
    public String postEditMaterial(@ModelAttribute News news, Model model, @RequestParam("Action") String action) {
        if(action.equals("save"))
        {
            try {
                news.setAuthor(accountService.getUserInfo());
                newsService.addNews(news);
                return "redirect:/news";
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                return "edit_news";
            }
        }
        if(action.equals("delete"))
        {
            try {
                news.setAuthor(accountService.getUserInfo());
                newsService.delNews(news);
                return "redirect:/news";
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
                return "edit_news";
            }
        }
        return "edit_material";
    }

    @PostMapping("/add_news")
    public String registerUser (@ModelAttribute News news, Model model) {
        try {
            news.setAuthor(accountService.getUserInfo());
            newsService.addNews(news);

            return "redirect:/news";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "add_news";
        }
    }


}
