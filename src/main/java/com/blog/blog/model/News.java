package com.blog.blog.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserAc author;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserAc getAuthor() { // Измените тип возвращаемого значения на CustomUser , если это необходимо
        return author;
    }

    public void setAuthor(UserAc author) { // Измените тип аргумента на CustomUser , если это необходимо
        this.author = author;
    }

}
