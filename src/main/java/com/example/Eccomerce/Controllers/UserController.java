package com.example.Eccomerce.Controllers;

import com.example.Eccomerce.Dto.UserDto;
import com.example.Eccomerce.Entities.User;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
       return ResponseEntity.ok(service.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se elimino correctamente el user con id : "+ id );
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) throws ResourceNotFoundException{
        return ResponseEntity.ok(service.update(user));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) throws ResourceNotFoundException{
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<User> findByMailAndPassword(@RequestBody UserDto userDto) throws ResourceNotFoundException{

        return ResponseEntity.ok(service.findByMailAndPassword(userDto.getMail(), userDto.getPassword()));



    }




}
