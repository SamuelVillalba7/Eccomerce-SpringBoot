package com.example.Eccomerce.Servicies;

import com.example.Eccomerce.Dto.OrderDetailDto;
import com.example.Eccomerce.Dto.OrderDto;
import com.example.Eccomerce.Dto.ProductDto;
import com.example.Eccomerce.Entities.Order;
import com.example.Eccomerce.Entities.OrderDetail;
import com.example.Eccomerce.Entities.Product;
import com.example.Eccomerce.Entities.User;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Repositories.OrderRepository;
import com.example.Eccomerce.Repositories.ProductRepository;
import com.example.Eccomerce.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepository repository;
    private UserRepository repositoryUser;
    private ProductService serviceProduct;
    private ProductRepository repositoryProduct;

    @Autowired
    public OrderService(OrderRepository repository, UserRepository repositoryUser, ProductService serviceProduct, ProductRepository repositoryProduct) {
        this.repository = repository;
        this.repositoryUser = repositoryUser;
        this.serviceProduct = serviceProduct;
        this.repositoryProduct = repositoryProduct;
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

    @Transactional
    public OrderDto save(OrderDto orderDto) throws ResourceNotFoundException {

        User user = repositoryUser.findById(orderDto.getIdUser())
                .orElseThrow(()->new ResourceNotFoundException("No se encontro user con id : "+ orderDto.getIdUser())) ;

        Order order = new Order();
        order.setUser(user);
        order.setDate(orderDto.getDate());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setPaymentMethod(orderDto.getPaymentMethod());

        List<Integer> productsNotFounds = new ArrayList<>();
        List<OrderDetail> listOrderDetail = orderDto.getOrderDetails().stream()
                .map(orderDetailDto -> {
                    Optional<Product> productOpc= repositoryProduct.findById(orderDetailDto.getIdProduct());
                    if(!productOpc.isPresent()){
                        productsNotFounds.add(orderDetailDto.getIdProduct());
                        return new OrderDetail(order,new Product(),orderDetailDto.getUnitPrice(),orderDetailDto.getQuantity());
                    }else {
                        Product product = productOpc.get();
                        return new OrderDetail(order,product,orderDetailDto.getUnitPrice(),orderDetailDto.getQuantity());
                    }

                }).toList();

        validateProductsExist(productsNotFounds);

        order.setOrderDetails(listOrderDetail);
        serviceProduct.discountStock(listOrderDetail);
        repository.save(order);

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

    private void validateProductsExist(List<Integer>productsNotFounds) throws ResourceNotFoundException {
        if(!productsNotFounds.isEmpty()){
            if(productsNotFounds.size()>1){
                String productIds = String.join(", ", productsNotFounds.stream()
                        .map(String::valueOf)
                        .toList());
                throw new ResourceNotFoundException("No se encontraron los siguientes productos : "+ productIds);
            }else {
                throw new ResourceNotFoundException("No se encontro el producto con id : "+ productsNotFounds.get(0));
            }
        }
    }

}
