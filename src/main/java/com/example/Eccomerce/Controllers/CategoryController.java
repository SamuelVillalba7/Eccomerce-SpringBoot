package com.example.Eccomerce.Controllers;


import com.example.Eccomerce.Entities.Category;
import com.example.Eccomerce.Servicies.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Category> findAll(){
        return service.findAll();
    }

    @GetMapping("findById/{id}")
    public Optional<Category> findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category){
        return service.update(category);
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
