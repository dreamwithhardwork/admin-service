package com.admin.controller;


import com.admin.AdminApplication;
import org.models.core.dao.MakeRepository;
import org.models.core.domain.Make;
import org.models.core.enums.MakeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AdminApplication.PATH+"/makemodel")
public class MakeModelController {

    @Autowired
    MakeRepository makeRepository;

    @PostMapping("/add")
    public Make add(@RequestBody Make make){
        return makeRepository.save(make);
    }

    @GetMapping("/all")
    public List<Make> getAll(@RequestParam("type") MakeType makeType){
        return makeRepository.findByType(makeType);
    }

    @GetMapping("/make/{name}")
    public Make getMakeByName(@PathVariable("name") String name){
        return makeRepository.findOneByName(name);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam("id") String id){
        makeRepository.deleteById(id);
        return true;
    }

}
