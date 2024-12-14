package com.example.Eccomerce.Entities;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "[ORDERS]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDORDER")
    private Integer id ;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name="IDUSER")
    private User user ;

    @Column(name = "TOTALAMOUNT" , columnDefinition = "money")
    private BigDecimal totalAmount;

    @Column(name="PAYMENTMETHOD")
    private String paymentMethod;

    @Column(name="DATE")
    private LocalDate date ;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
