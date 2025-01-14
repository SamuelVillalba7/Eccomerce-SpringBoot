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
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findByCategory/{id}")
    public ResponseEntity<List<ProductDto>> findByCategory(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.findByCategory(id));
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProductDto productDto) throws ResourceNotFoundException {
        ProductDto dto= service.save(productDto);
        return ResponseEntity.ok("se agrego correctamente , su id es : "+dto.getId());
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ProductDto productDto) throws ResourceNotFoundException {
        service.update(productDto);
        return ResponseEntity.ok("se modifico correctamente el producto con id : " + productDto.getId() );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.ok("se elimino correctamente el producto con id : "+ id);

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/lowLogic")
    public ResponseEntity<String> lowLogic(@RequestParam Integer id) throws ResourceNotFoundException {
        service.lowLogic(id);
        return ResponseEntity.ok("se dio baja logica correctamente a producto con id : "+ id);
    }
    @PutMapping("/highLogic")
    public ResponseEntity<String> highLogic(@RequestParam Integer id) throws ResourceNotFoundException {
        service.highLogic(id);
        return ResponseEntity.ok("se dio de alta logica correctamente a producto con id : "+ id);
    }

}
