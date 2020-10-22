package com.admin.controller;

import com.admin.AdminApplication;
import org.models.core.dao.UsersRepository;
import org.models.core.users.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AdminApplication.PATH+"/registered/users")
public class UsersController {


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<RegisteredUser> getAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/get/{email}")
    public RegisteredUser getUsernameByEmail(@RequestParam("email") String email){
        return usersRepository.findOneByEmail(email);
    }

    @GetMapping("/get/{mobile}")
    public RegisteredUser getUsernameByMobile(@RequestParam("mobile") String mobile){
        return usersRepository.findOneByMobile(mobile);
    }

    @DeleteMapping("/delete/{mobile}")
    public Boolean deleteUserByMobile(@PathVariable("mobile") String mobile){
        usersRepository.delete(usersRepository.findOneByMobile(mobile));
        return  true;
    }

    @DeleteMapping("/delete/{email}")
    public Boolean deleteUserByemail(@PathVariable("email") String email){
        usersRepository.delete(usersRepository.findOneByMobile(email));
        return  true;
    }

    @PostMapping("/add")
    public RegisteredUser addUser(@RequestBody RegisteredUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }


}
