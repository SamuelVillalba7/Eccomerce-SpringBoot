package com.example.Eccomerce.Dto;

import com.example.Eccomerce.Entities.Category;

import java.math.BigDecimal;

public class ProductDto {
    private Integer id;
    private String name;
    private Integer id_category;
    private String description;
    private BigDecimal price;
    private String urlImage;
    private Integer stock;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name,Integer stock , BigDecimal price, String urlImage, String description, Integer id_category) {
        this.id = id;
        this.name = name;
        this.id_category = id_category;
        this.price = price;
        this.urlImage = urlImage;
        this.description = description;
        this.stock= stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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
