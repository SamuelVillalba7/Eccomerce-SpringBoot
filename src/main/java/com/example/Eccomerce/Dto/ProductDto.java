package com.example.Eccomerce.Dto;

import com.example.Eccomerce.Entities.Category;

import java.math.BigDecimal;

public class ProductDto {
    private Integer id;
    private String name;
    private Integer idCategory;
    private String description;
    private BigDecimal price;
    private String urlImage;
    private Integer stock;
    private Boolean state;
    public ProductDto() {
    }

    public ProductDto(Integer id, String name,Boolean state ,Integer stock , BigDecimal price, String urlImage, String description, Integer idCategory) {
        this.id = id;
        this.name = name;
        this.idCategory = idCategory;
        this.price = price;
        this.urlImage = urlImage;
        this.description = description;
        this.stock= stock;
        this.state= state;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer id_category) {
        this.idCategory = id_category;
    }
}
