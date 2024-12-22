package com.example.Eccomerce.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCATEGORY")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URLIMAGE")
    private String urlImage;

    @Column(name = "COLOR" )
    private String color;

    @Column(name = "STATE" , columnDefinition = "BIT DEFAULT 1")
    private Boolean state;


    public Category() {}

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

