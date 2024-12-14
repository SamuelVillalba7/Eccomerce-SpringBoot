package com.example.Eccomerce.Repositories;

import com.example.Eccomerce.Entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
