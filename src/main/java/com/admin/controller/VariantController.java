package com.admin.controller;

import org.models.core.dao.VariantRepository;
import org.models.core.domain.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variant")
public class VariantController {


    @Autowired
    VariantRepository variantRepository;


    @PostMapping("/add")
    public Variant add(@RequestBody Variant variant){
        return variantRepository.save(variant);
    }

    @GetMapping
    public List<Variant> getAll(){
        return variantRepository.findAll();
    }
}

