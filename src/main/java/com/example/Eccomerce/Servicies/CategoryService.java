package com.example.Eccomerce.Servicies;

import com.example.Eccomerce.Entities.Category;
import com.example.Eccomerce.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    public CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Category update(Category category){
        return repository.save(category);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
    public Optional<Category> findById(Integer id){
        return repository.findById(id);
    }

    public List<Category> findAll(){
        return repository.findAll();
    }



}
