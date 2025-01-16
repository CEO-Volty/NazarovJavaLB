package com.blog.blog.repository;

import com.blog.blog.model.UserAc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAc, Long> {
    UserAc findByUsername(String username);
}
