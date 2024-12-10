package com.example.Eccomerce.Repositories;


import com.example.Eccomerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.mail = ?1 AND u.password = ?2")
     Optional<User> findByMailAndPassword(String mail, String password);
}
