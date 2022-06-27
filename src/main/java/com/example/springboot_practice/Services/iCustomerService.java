package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Customer;

import java.util.List;
import java.util.Optional;

public interface iCustomerService {
    public List<Customer> getAllCustomers();
    // public Customer getCustomerByBookId(int id);
    public Optional<Customer> getCustomerById(int id);
    public Customer addCustomer(Customer customer);
}
