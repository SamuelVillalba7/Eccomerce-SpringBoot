package com.example.Eccomerce.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="PRODUCTOS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDPRODUCT")
    private Integer id ;
    @Column(name="NAME")
    private String name;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCATEGORY")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
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
}
