package com.example.Eccomerce.Dto;

import com.example.Eccomerce.Entities.OrderDetail;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderDto {

    private Integer id;
    private Integer idUser;
    private BigDecimal totalAmount;
    private LocalDate date;
    private String paymentMethod;
    private List<OrderDetailDto> orderDetails;

    public OrderDto() {
    }

    public OrderDto(Integer id, Integer idUser, BigDecimal totalAmount, LocalDate date, String paymentMethod, List<OrderDetailDto> orderDetails) {
        this.id = id;
        this.idUser = idUser;
        this.totalAmount = totalAmount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.orderDetails = orderDetails;
    }

    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}


