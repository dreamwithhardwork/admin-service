package com.admin.controller;



import org.models.core.dao.SearchRepository;
import org.models.core.dao.VehicleRepository;
import org.models.core.domain.Vehicle;
import org.models.core.error.model.MakeError;
import org.models.core.properies.VehicleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicle")
public class CarsController {

    @Autowired
    VehicleRepository autoMobileRepository;

    @Autowired
    SearchRepository searchRepository;


    @Autowired
    VehicleProperties vehicleProperties;


    @PostMapping("/add")
    public Vehicle add(@RequestBody @Valid Vehicle car){
        return autoMobileRepository.save(car);
    }

    @GetMapping
    public List<Vehicle> getAll(){
        return autoMobileRepository.findAll();
    }

    @DeleteMapping
    public void  deleteAll()
    {
        autoMobileRepository.deleteAll();
    }



}
