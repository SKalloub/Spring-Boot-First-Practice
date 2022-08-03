package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Customer;
import com.example.springboot_practice.Repositories.BookRepository;
import com.example.springboot_practice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements iCustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
   public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
   }
   @Override
   public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

//    public Customer getCustomerByBookId(int id) {
//        Book b = bookRepository.findById(id).orElse(null);
//        if (b==null)
//            return null;
//
//        List<Customer> customers = customerRepository.findAll();
//        return customers.stream().filter(
//                customer -> id == customer.getBooks().stream().filter(
//                        book -> book.getId() == id).findFirst().
//                        orElse(null).getId()).findFirst().orElse(null);
//    }

   @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
