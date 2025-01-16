package com.blog.blog.service;

import com.blog.blog.model.Material;
import com.blog.blog.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private UserService userService;


    public List<Material> getMaterialsByUserId(Long userId) {

        return materialRepository.findByUserAcId(userId);
    }

    public Material getMaterialsById(Long id) {

        Optional<Material> material = materialRepository.findById(id);
        return material.orElse(null);
    }

    public void addMaterial (Material material) throws IllegalArgumentException {
        materialRepository.save(material);
    }


    public void delMaterial (Material material) throws IllegalArgumentException {
        materialRepository.delete(material);
    }


}
