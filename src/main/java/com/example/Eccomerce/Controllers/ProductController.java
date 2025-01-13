package com.example.Eccomerce.Controllers;


import com.example.Eccomerce.Dto.ProductDto;
import com.example.Eccomerce.Entities.Product;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<ProductDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/findByCategory/{id}")
    public List<ProductDto> findByCategory(@PathVariable Integer id){
        return service.findByCategory(id);
    }

    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto productDto){
        return service.save(productDto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) throws ResourceNotFoundException {
        ProductDto dto = service.update(productDto);
        return ResponseEntity.status(HttpStatus.OK).body("me modifico el producto con id : " + dto.getId());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        service.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<ProductDto> findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping("/lowLogic")
    public ProductDto lowLogic(@RequestParam Integer id) throws ResourceNotFoundException {
        return  service.lowLogic(id);
    }
    @PutMapping("/highLogic")
    public ProductDto highLogic(@RequestParam Integer id) throws ResourceNotFoundException {
        return  service.highLogic(id);
    }

}
