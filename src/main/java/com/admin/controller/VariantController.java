package com.admin.controller;

import com.admin.AdminApplication;
import com.admin.util.Util;
import org.models.core.dao.VariantRepository;
import org.models.core.domain.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AdminApplication.PATH+"/variant")
public class VariantController {


    @Autowired
    VariantRepository variantRepository;


    @PostMapping("/add")
    public Variant add(@RequestBody Variant variant)
    {
        variant.set_variantName(Util.generateIdFromUniqueName(
                variant.getVariantName()+variant.getFromYear()));
        return variantRepository.save(variant);
    }
    @GetMapping("/all")
    public List<Variant> getAll(){
        return variantRepository.findAll();
    }

    @GetMapping
    public Variant getVariantById(@RequestParam("id") String id){
        Optional<Variant> res = variantRepository.findById(id);
        return res.get();
    }

    @DeleteMapping
    public Boolean delete(@RequestParam("id") String id){
        variantRepository.deleteById(id);
        return  true;
    }
}

