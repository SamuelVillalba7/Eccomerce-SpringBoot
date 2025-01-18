package com.example.Eccomerce.Servicies;

import com.example.Eccomerce.Entities.Category;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
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

    private Category getCategoryOrThrow(Integer id) throws ResourceNotFoundException {
        return  repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no se encontro categoria con id : " + id));
    }
    public Category save(Category category){
        return repository.save(category);
    }

    public Category update(Category category) throws ResourceNotFoundException {
        getCategoryOrThrow(category.getId());
        return repository.save(category);
    }

    public void delete(Integer id) throws ResourceNotFoundException {
        getCategoryOrThrow(id);
        repository.deleteById(id);
    }
    public Category findById(Integer id) throws ResourceNotFoundException {
        return  getCategoryOrThrow(id);
    }

    public List<Category> findAll(){
        return repository.findAll();
    }



}
