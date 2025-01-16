package com.blog.blog.repository;

import com.blog.blog.model.Material;
import com.blog.blog.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByAuthorId(Long authorId);
    Optional<News> findById(Long id);
}
