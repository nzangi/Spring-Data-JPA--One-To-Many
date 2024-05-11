package com.springjpa.controller;

import com.springjpa.dto.OrderRequest;
import com.springjpa.dto.OrderResponse;
import com.springjpa.entity.Customer;
import com.springjpa.repository.CustomerRepository;
import com.springjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerRepository.save(orderRequest.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getJointInformation")
    public List<OrderResponse> getJointInformation(){
        return customerRepository.getJoinInformation();
    }

}
