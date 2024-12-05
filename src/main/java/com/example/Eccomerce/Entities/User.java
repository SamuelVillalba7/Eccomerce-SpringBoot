package com.example.Eccomerce.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSER")
    private Integer id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name="LASTNAME", length = 50)
    private String lastname;

    @Column(name="MAIL", length = 150)
    private String mail;

    @Column(name ="ADMIN", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean admin ;
}
