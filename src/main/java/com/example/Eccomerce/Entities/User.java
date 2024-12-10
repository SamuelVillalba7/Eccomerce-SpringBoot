package com.example.Eccomerce.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "[USERS]")
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

    @Column(name="PASSWORD")
    private String password;

    @Column(name ="ADMIN", columnDefinition = "BIT DEFAULT 0")
    private Boolean admin ;

    public User() {
    }

    public User(Integer id, String name, String mail, String password, Boolean admin, String lastname) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
