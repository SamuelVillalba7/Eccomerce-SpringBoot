package com.example.Eccomerce.Dto;

import java.math.BigDecimal;

public class OrderDetailDto {

    private Integer id;
    private BigDecimal unitPrice;
    private Integer idOrder;
    private Integer idProduct ;
    private Integer quantity;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Integer id, Integer idOrder, BigDecimal unitPrice, Integer quantity, Integer idProduct) {
        this.id = id;
        this.idOrder = idOrder;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.idProduct = idProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
