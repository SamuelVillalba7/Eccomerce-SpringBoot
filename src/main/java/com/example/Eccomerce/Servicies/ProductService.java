package com.example.Eccomerce.Servicies;

import com.example.Eccomerce.Entities.Product;
import com.example.Eccomerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public ProductRepository repository;
    @Autowired
    public ProductService(ProductRepository repository){
        this.repository=repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product update(Product product){
        return repository.save(product);
    }

    public Product save(ProductDto product){
        return repository.save(product);
    }

    public Optional<Product> findById(Integer id){
        return repository.findById(id);
    }

    public void deleteById(Integer id){
         repository.deleteById(id);
    }


}
