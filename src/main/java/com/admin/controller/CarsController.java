package com.admin.controller;



import org.models.core.dao.SearchRepository;
import org.models.core.dao.VehicleRepository;
import org.models.core.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class CarsController {

    @Autowired
    VehicleRepository autoMobileRepository;

    @Autowired
    SearchRepository searchRepository;




    @PostMapping("/add")
    public Vehicle add(@RequestBody Vehicle car){
        System.out.println(car.getMake());
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
