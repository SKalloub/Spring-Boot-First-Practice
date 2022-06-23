package com.example.springboot_practice.Repositories;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository {
    private static CustomerRepository customerRepository;

    private CustomerRepository(){
        customerList = new ArrayList<>();
    }

    public static CustomerRepository getRepository(){
        if (customerRepository==null)
            customerRepository = new CustomerRepository();

        return customerRepository;
    }
    private List<Customer> customerList;

    public List<Customer> getAllCustomers() {
        return customerList;
    }
    public Customer getCustomerById(int id) {
        return customerList.stream().filter(customer -> customer.getId() == id)
                .findAny()
                .orElse(null);
    }
    public Customer getCustomerByBookId(int id) {
        for (Customer c: customerList) {
            for (Book b: c.getBooks()) {
                if (b.getId()==id)
                    return c;
            }
        }
        return null;
    }
    public boolean addCustomer(String name){
        Customer c = new Customer(customerList.size()+1,name);
        return customerList.add(c);
    }
}
