package com.blog.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime; // Импортируйте LocalDateTime
import java.util.Set;

@Entity
public class UserAc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private boolean isAdmin;
    private String email;

    @OneToMany(mappedBy = "userAc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Material> materials;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<News> newsSet;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    public Set<News> getNews() {
        return newsSet;
    }

    public void setNews(Set<News> news) {
        this.newsSet = news;
    }
}
