package com.admin.controller;

import com.admin.AdminApplication;
import org.models.core.dao.AvailableCarPropertiesRepository;
import org.models.core.domain.AvailableCarProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AdminApplication.PATH+"/properties")
public class PropertiesController {


    @Autowired
    AvailableCarPropertiesRepository availableCarPropertiesRepository;


    @PostMapping("/add/car")
    public AvailableCarProperties add(@RequestBody  AvailableCarProperties availableCarProperties){
        return   availableCarPropertiesRepository.save(availableCarProperties);
    }

    @GetMapping("/get/car")
    public List<AvailableCarProperties> get(){
        return availableCarPropertiesRepository.findAll();
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam(name = "id", required = true) String id){
          availableCarPropertiesRepository.deleteById(id);
          return true;
    }


}
