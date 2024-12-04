package com.example.Eccomerce.Controllers;


import com.example.Eccomerce.Entities.Product;
import com.example.Eccomerce.Servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service=service;
    }
    @GetMapping("/findAll")
    public List<Product> findAll(){
        return service.findAll();
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        return service.update(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        service.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<Product> findById(@PathVariable Integer id){
        return service.findById(id);
    }

}
