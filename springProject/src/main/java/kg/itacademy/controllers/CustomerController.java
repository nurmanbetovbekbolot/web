package kg.itacademy.controllers;
import kg.itacademy.entities.Customer;
import kg.itacademy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService CustomerService;

    @GetMapping
    public List<Customer> getAll() {
        return CustomerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Customer getById(@PathVariable("id")Long id) {
        return CustomerService.getById(id);
    }

    @PutMapping
    public Customer update(@RequestBody Customer a) {
        return CustomerService.update(a);
    }

    @PostMapping
    public void create(@RequestBody Customer customer) {
        CustomerService.create(customer);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        CustomerService.deleteById(id);
    }
}


