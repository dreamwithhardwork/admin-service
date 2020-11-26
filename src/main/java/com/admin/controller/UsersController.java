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
@CrossOrigin(origins = "*")
public class UsersController {


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/all")
    public List<RegisteredUser> getAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/email/{email}")
    public RegisteredUser getUsernameByEmail(@PathVariable("email") String email){
        return usersRepository.findOneByEmail(email);
    }

    @GetMapping("/mobile/{mobile}")
    public RegisteredUser getUsernameByMobile(@PathVariable("mobile") String mobile){
        return usersRepository.findOneByMobile(mobile);
    }

    @DeleteMapping("/delete/mobile{mobile}")
    public Boolean deleteUserByMobile(@PathVariable("mobile") String mobile){
        usersRepository.delete(usersRepository.findOneByMobile(mobile));
        return  true;
    }

    @DeleteMapping("/delete/email/{email}")
    public Boolean deleteUserByemail(@PathVariable("email") String email){
        usersRepository.delete(usersRepository.findOneByMobile(email));
        return  true;
    }

    @DeleteMapping("/delete/id/{id}")
    public Boolean deleteUserById(@PathVariable("id") String id){
        usersRepository.deleteById(id);
        return  true;
    }

    @PostMapping("/add")
    public RegisteredUser addUser(@RequestBody RegisteredUser user){
        String password = user.getName()+"!@";
        user.setPassword(password);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }


}
