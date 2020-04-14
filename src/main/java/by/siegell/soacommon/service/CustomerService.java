package by.siegell.soacommon.service;

import by.siegell.soacommon.client.bank.BankClient;
import by.siegell.soacommon.domain.Customer;
import by.siegell.soacommon.domain.exception.EntityNotFoundException;
import by.siegell.soacommon.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    private BankClient bankClient;

    public Customer createCustomer(String name, UUID bankAccount) {
        if (customerRepository.existsByBankAccount(bankAccount)) {
            // TODO throw already exists error
        }
        return customerRepository.save(Customer.builder()
                .id(null)
                .name(name)
                .bankAccount(bankAccount)
                .build());
    }

    public Customer createCustomer(String name) {
        return createCustomer(name, bankClient.createAccount());
    }

    public Customer findCustomerById(UUID id) throws EntityNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer newCustomer) throws EntityNotFoundException {
        Optional<Customer> optionalOldCustomer = customerRepository.findById(newCustomer.getId());
        if (optionalOldCustomer.isPresent()) {
            Customer oldCustomer = optionalOldCustomer.get();
            if (oldCustomer.getBankAccount() == newCustomer.getBankAccount()) {
                return customerRepository.save(newCustomer);
            }
        }
        throw new EntityNotFoundException();
    }

    public void deleteCustomerById(UUID id) {
        customerRepository.deleteById(id);
    }
}
