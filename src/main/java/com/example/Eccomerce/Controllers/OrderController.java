package com.example.Eccomerce.Controllers;

import com.example.Eccomerce.Dto.OrderDto;
import com.example.Eccomerce.Entities.Order;
import com.example.Eccomerce.Servicies.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<OrderDto>findAll(){
        return service.findAll();
    }

    @PostMapping("/save")
    public OrderDto save (@RequestBody OrderDto orderDto){
        return service.save(orderDto);
    }

    @PostMapping("/saveFuncional")
    public OrderDto saveFuncional (@RequestBody OrderDto orderDto){
        return service.saveFuncional(orderDto);
    }



}
