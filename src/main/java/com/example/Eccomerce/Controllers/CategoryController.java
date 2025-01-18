package com.example.Eccomerce.Controllers;


import com.example.Eccomerce.Entities.Category;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Servicies.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    public final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) throws ResourceNotFoundException{
        return ResponseEntity.ok(service.update(category));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.ok(service.save(category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Se elimino correctamente la category con id : "+ id );
    }

}
