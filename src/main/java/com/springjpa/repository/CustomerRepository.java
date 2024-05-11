package com.springjpa.repository;

import com.springjpa.dto.OrderResponse;
import com.springjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.springjpa.dto.OrderResponse(c.customerName,p.productName,p.productPrice) from Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
