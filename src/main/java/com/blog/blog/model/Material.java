package com.blog.blog.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String material_name;
    private String color;
    private Integer weight;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAc userAc;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public UserAc getUserAc () {
        return userAc; // Добавляем геттер для user
    }

    public void setUserAc (UserAc userAc) {
        this.userAc = userAc; // Добавляем сеттер для user
    }

}

