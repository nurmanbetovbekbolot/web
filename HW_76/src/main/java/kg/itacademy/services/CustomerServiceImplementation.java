package kg.itacademy.services;

import kg.itacademy.entities.Customer;
import kg.itacademy.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(new Customer());
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
        System.out.println("Customer with id " + id + " has been deleted");
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
        System.out.println("Successfully created");
    }

    @Override
    public void setActiveness(Customer customer, boolean result) {
        customer.setActive(result);
        customerRepository.save(customer);
        System.out.println("Customer's status is " + (result ? "active": "inactive"));
    }

}
