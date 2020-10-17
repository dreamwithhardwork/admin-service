package com.admin.controller;

import org.models.core.dao.RTORepository;
import org.models.core.location.RTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rto")
public class RTOController {

    @Autowired
    RTORepository rtoRepository;

    @PostMapping("/add")
    public RTO addRto(@RequestBody RTO rto){
       return rtoRepository.save(rto);
    }

    @GetMapping("/getAll")
    public List<RTO> getAll(@RequestParam("operating") Optional<Boolean> operating){
        return operating.isEmpty()?rtoRepository.findAll():rtoRepository.findByOperating(operating.get());
    }


}
