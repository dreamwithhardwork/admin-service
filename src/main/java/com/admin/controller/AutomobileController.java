package com.admin.controller;



import com.admin.AdminApplication;
import io.swagger.annotations.ApiParam;
import org.models.core.dao.SearchFilterRepository;
import org.models.core.dao.SearchRepository;
import org.models.core.dao.VehicleRepository;
import org.models.core.domain.Vehicle;
import org.models.core.enums.AutomobileType;
import org.models.core.enums.VehicleStatus;
import org.models.core.error.model.MakeError;
import org.models.core.properies.VehicleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(AdminApplication.PATH+"/vehicle")

public class AutomobileController {



    @Autowired
    VehicleRepository autoMobileRepository;

    @Autowired
    SearchFilterRepository searchFilterRepository;


    @PostMapping("/add")
    public Vehicle add(@RequestBody @Valid Vehicle vehicle){
        return autoMobileRepository.save(vehicle);
    }

    @GetMapping("/all")
    public List<Vehicle> getAll(){
        return autoMobileRepository.findAll();
    }

    @DeleteMapping
    public Boolean delete(@RequestParam("id") String id){
        autoMobileRepository.deleteById(id);
        return  true;
    }
    @GetMapping("/filter")
    List<Vehicle> getAllByFilter(@RequestParam("color") Optional<String> color, @RequestParam("year") Optional<Integer> year,
                                 @RequestParam("make") Optional<String> make, @RequestParam("model") Optional<String> model,
                                 @RequestParam("fromPrice") Optional<Float> minPrice, @RequestParam("toPrice") Optional<Float> maxPrice ,
                                 @RequestParam("fromMileage") Optional<Integer> minMileage, @RequestParam("toMileage") Optional<Integer> maxMileage
            , @RequestParam("type") AutomobileType type, @RequestParam("status") VehicleStatus status){
        Map<String,Object> filter = new HashMap<>();
        filter.put("color",color.orElse(null));
        filter.put("year",year.orElse(null));
        filter.put("make",make.orElse(null));
        filter.put("model",model.orElse(null));
        filter.put("minPrice",minPrice.orElse(null));
        filter.put("maxPrice",maxPrice.orElse(null));
        filter.put("minMileage",minMileage.orElse(null));
        filter.put("maxMileage",maxMileage.orElse(null));
        filter.put("automobileType",type.toString());
        filter.put("status", status);
        return searchFilterRepository.getVehiclesByFilter(filter);
    }


}
