package com.example.Eccomerce.Dto;

import com.example.Eccomerce.Entities.Category;

public class ProductDto {
    private Integer id;
    private String name;
    private Integer id_category;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Integer id_category) {
        this.id = id;
        this.name = name;
        this.id_category = id_category;
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

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }
}
