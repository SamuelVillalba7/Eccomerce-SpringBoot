package com.example.Eccomerce.Controllers;

import com.example.Eccomerce.Entities.User;
import com.example.Eccomerce.Servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    public final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public List<User>findAll(){
        return service.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return service.update(user);
    }

    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable Integer id){
        return service.findById(id);
    }






}
