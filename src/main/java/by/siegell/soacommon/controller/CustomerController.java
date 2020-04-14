package by.siegell.soacommon.controller;

import by.siegell.soacommon.domain.Customer;
import by.siegell.soacommon.domain.exception.EntityNotFoundException;
import by.siegell.soacommon.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/")
    public Customer createCustomer(@RequestBody String name, @RequestBody(required = false) UUID bankAccount) {
        if (bankAccount != null) {
            return customerService.createCustomer(name, bankAccount);
        } else {
            return customerService.createCustomer(name);
        }
    }

    @GetMapping("/")
    public List<Customer> getCustomerAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id) throws EntityNotFoundException {
        return customerService.findCustomerById(id);
    }

    @PutMapping("/")
    public Customer updateCustomer(@RequestBody Customer customer) throws EntityNotFoundException {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomerById(id);
    }

}
