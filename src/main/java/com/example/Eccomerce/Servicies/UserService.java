package com.example.Eccomerce.Servicies;


import com.example.Eccomerce.Entities.User;
import com.example.Eccomerce.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user){
        return repository.save(user);
    }

    public User update(User user){
        return repository.save(user);
    }

    public Optional<User> findById(Integer id){
        return repository.findById(id);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public void delete (Integer id){
        repository.deleteById(id);
    }
}
