package com.admin.controller;


import com.admin.AdminApplication;
import com.admin.util.Util;
import org.models.core.dao.CustomRepositories;
import org.models.core.dao.MakeRepository;
import org.models.core.dao.ModelRepository;
import org.models.core.domain.Make;
import org.models.core.domain.Model;
import org.models.core.domain.ModelsFilter;
import org.models.core.enums.MakeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AdminApplication.PATH+"/model")
public class ModelController {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    CustomRepositories customRepositories;

    @PostMapping("/add")
    public Model add(@RequestBody Model model){
        model.set_idname(Util.generateIdFromUniqueName(model.getName()));
        return modelRepository.save(model);
    }

    @GetMapping
    public List<Model> getAll(@RequestParam("make") String make){
        return modelRepository.findByMake(make);
    }

    @GetMapping("/all")
    public List<Model> getMakeByName(){
        return customRepositories.getAllModels();
    }

    @PutMapping
    public List<Model> getAllModels(@RequestBody ModelsFilter filter){
        return customRepositories.getAllModels(filter);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam("id") String id){
        modelRepository.deleteById(id);
        return true;
    }
}
