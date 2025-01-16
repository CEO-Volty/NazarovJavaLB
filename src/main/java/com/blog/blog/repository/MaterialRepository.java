package com.blog.blog.repository;

import com.blog.blog.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByUserAcId(Long userId);
    Optional<Material> findById(Long id);
}
