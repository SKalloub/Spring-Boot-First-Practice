package com.example.springboot_practice.Controllers;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Model.Customer;
import com.example.springboot_practice.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerController {
    @Autowired
     CustomerService customerService;


@GetMapping
    public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
}
//@GetMapping("/{id}")
//    public Customer getCustomerId(@PathVariable(name="id") int id) {
//    return customerService.getCustomerById(id);
//}
@PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
    Customer customer1 = customerService.addCustomer(customer);
    if (customer1!=null)
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    else
        return new ResponseEntity<>(customer1, HttpStatus.BAD_REQUEST);

}

}
