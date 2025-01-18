package com.example.Eccomerce.Controllers;

import com.example.Eccomerce.Dto.OrderDto;
import com.example.Eccomerce.Entities.Order;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Servicies.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {
    public OrderService service ;
    @Autowired

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OrderDto>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<OrderDto> save (@RequestBody OrderDto orderDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.save(orderDto));
    }



}
