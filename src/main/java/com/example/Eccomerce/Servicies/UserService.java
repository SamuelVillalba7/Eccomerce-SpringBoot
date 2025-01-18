package com.example.Eccomerce.Servicies;


import com.example.Eccomerce.Entities.User;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
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

    public User save(User user) {

        return repository.save(user);
    }

    private User getUserOrThrow(Integer id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro user con id : " + id));
    }

    public User update(User user) throws ResourceNotFoundException {
        getUserOrThrow(user.getId());
        return repository.save(user);
    }

    public User findById(Integer id) throws ResourceNotFoundException {
        return getUserOrThrow(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) throws ResourceNotFoundException {
        getUserOrThrow(id);
        repository.deleteById(id);
    }

    public User findByMailAndPassword(String mail, String password) throws ResourceNotFoundException {

        return repository.findByMailAndPassword(mail,password)
                .orElseThrow(()->new ResourceNotFoundException("No se encontro un user con ese mail o la constraseña es incorrecta"));
    }
}