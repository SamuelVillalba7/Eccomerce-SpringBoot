package com.example.Eccomerce.Servicies;

import com.example.Eccomerce.Dto.OrderDetailDto;
import com.example.Eccomerce.Dto.OrderDto;
import com.example.Eccomerce.Entities.Order;
import com.example.Eccomerce.Entities.OrderDetail;
import com.example.Eccomerce.Entities.Product;
import com.example.Eccomerce.Entities.User;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Repositories.OrderRepository;
import com.example.Eccomerce.Repositories.ProductRepository;
import com.example.Eccomerce.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepository repository;
    private UserRepository repositoryUser;
    private ProductRepository repositoryProduct;
    private ProductService serviceProduct;

    @Autowired
    public OrderService(OrderRepository repository, ProductRepository repositoryProduct, UserRepository repositoryUser,ProductService serviceProduct) {
        this.repository = repository;
        this.repositoryProduct = repositoryProduct;
        this.repositoryUser = repositoryUser;
        this.serviceProduct = serviceProduct;
    }

    public List<OrderDto> findAll(){
        List<Order>list= repository.findAll();
        List<OrderDto>listDto= list.stream().map(order->{
            return convertToDto(order);
        })
                .collect(Collectors.toList());
        return listDto;
    }

    public OrderDto saveFuncional(OrderDto orderDto){
        User user = repositoryUser.findById(orderDto.getIdUser())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Order order = new Order();
        order.setUser(user);
        order.setDate(orderDto.getDate());
        order.setPaymentMethod(orderDto.getPaymentMethod());
        order.setTotalAmount(orderDto.getTotalAmount());

        List<OrderDetail> orderDetails = orderDto.getOrderDetails().stream()
                .map(orderDetailDto -> {
                    Product product = repositoryProduct.findById(orderDetailDto.getIdProduct())
                            .orElseThrow(()->new RuntimeException("Product not found"));
                    return new OrderDetail(order,product,orderDetailDto.getUnitPrice(),orderDetailDto.getQuantity());
                }).collect(Collectors.toList());
        order.setOrderDetails(orderDetails);

        return convertToDto(order);

    }


    public OrderDto save(OrderDto orderDto) throws ResourceNotFoundException {

        Order order = new Order();
        Optional<User> userOpc = null;
        userOpc = repositoryUser.findById(orderDto.getIdUser());
        if(userOpc.isPresent()){
            User user = userOpc.get();
            order.setUser(user);
            order.setDate(orderDto.getDate());
            order.setTotalAmount(orderDto.getTotalAmount());
            order.setPaymentMethod(orderDto.getPaymentMethod());
            repository.save(order);

        }
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for(OrderDetailDto detail : orderDto.getOrderDetails()){

            Optional<Product> productOpc = repositoryProduct.findById(detail.getIdProduct());
            if(productOpc.isPresent()){
                Product product = productOpc.get();
                orderDetailList.add( new OrderDetail(order,product,detail.getUnitPrice(),detail.getQuantity()));
            }
        }

        order.setOrderDetails(orderDetailList);
        update(order);
        serviceProduct.discountStock(orderDetailList);
      return convertToDto(order);
    }


    public OrderDto convertToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setIdUser(order.getUser().getId());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setOrderDetails(order.getOrderDetails().stream()
                .map(detail -> {
                    OrderDetailDto detailDto = new OrderDetailDto();
                    detailDto.setId(detail.getId());
                    detailDto.setIdOrder(detail.getOrder().getId());
                    detailDto.setIdProduct(detail.getProduct().getId());
                    detailDto.setQuantity(detail.getQuantity());
                    detailDto.setUnitPrice(detail.getUnitPrice());
                    return detailDto;
                })
                .collect(Collectors.toList()));
        return dto;
    }


    public Order update (Order order){
        return repository.save(order);
    }





}
