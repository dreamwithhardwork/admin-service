package com.admin.controller;


import com.admin.AdminApplication;
import com.admin.util.Util;
import org.models.core.dao.MakeRepository;
import org.models.core.domain.Make;
import org.models.core.enums.MakeType;
import org.models.core.properies.VehicleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(AdminApplication.PATH+"/make")
public class MakeController {

    @Autowired
    MakeRepository makeRepository;

    @Autowired
    VehicleProperties properties;

    @PostMapping("/add")
    public Make add(@RequestBody  Make make){
        make.set_name(Util.generateIdFromUniqueName(make.getName()+make.getType().name()));
        Make resp = null;
        try{
           resp =  makeRepository.save(make);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resp;
    }

    @GetMapping("/all")
    public List<Make> getAll(@RequestParam("type") MakeType makeType){
        return makeRepository.findByType(makeType);
    }

    @GetMapping("/make-model")
    public Map<String, Map<String, Set<String>>> getMakeModelList(){
       return properties.getMakemodelvariants();
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
