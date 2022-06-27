package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Customer;
import com.example.springboot_practice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements iCustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
   public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
   }
   @Override
   public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
   /*
    public Customer getCustomerByBookId(int id) {
        return customerRepository.getCustomerByBookId(id);
    }
    */
   @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
