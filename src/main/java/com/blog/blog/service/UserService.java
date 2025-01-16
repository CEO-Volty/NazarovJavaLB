package com.blog.blog.service;

import com.blog.blog.model.UserAc;
import com.blog.blog.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser (UserAc userAc) throws IllegalArgumentException {
        validatePassword(userAc.getPassword());
        userAc.setPassword(passwordEncoder.encode(userAc.getPassword()));
        userRepository.save(userAc);
    }

    private void validatePassword(String password) {
        if (password.length() < 5) {
            throw new IllegalArgumentException("Пароль должен содержать минимум 8 символов.");
        }

    }

    public UserAc findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUser (UserAc userAc) {
        userRepository.save(userAc);
    }

    public void deleteUser (Long userAc) {
        userRepository.deleteById(userAc);
    }
}
