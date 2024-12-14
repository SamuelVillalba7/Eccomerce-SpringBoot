package com.example.Eccomerce.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDORDERDETAIL")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="IDORDER")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "IDPRODUCT")
    private Product product;

    @Column(name="UNITPRICE", columnDefinition = "money")
    private BigDecimal unitPrice;

    @Column(name="QUANTITY")
    private Integer quantity;

    public OrderDetail(Integer id, Order order, Product product, BigDecimal unitPrice, Integer quantity) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}
