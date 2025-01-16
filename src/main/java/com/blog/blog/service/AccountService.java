package com.blog.blog.service;


import com.blog.blog.model.UserAc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    private UserService userService;

    public UserAc getUserInfo(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        UserAc currentUserAc = userService.findByUsername(currentUsername);

        return currentUserAc;
    }

    public boolean isAdmin() {
        UserAc currentUserAc = getUserInfo();
        return currentUserAc != null && currentUserAc.isAdmin();
    }

}

