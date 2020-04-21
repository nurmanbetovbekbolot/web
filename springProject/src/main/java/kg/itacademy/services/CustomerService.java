package kg.itacademy.services;

import kg.itacademy.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(Long id);
    Customer update(Customer customer);
    void deleteById(Long id);
    void create(Customer customer);
}
