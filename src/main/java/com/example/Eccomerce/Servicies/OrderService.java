package com.example.Eccomerce.Servicies;

import com.example.Eccomerce.Entities.Order;
import com.example.Eccomerce.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order save(Order order){
        return repository.save(order);
    }
}
