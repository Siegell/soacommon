package by.siegell.soacommon.repository;

import by.siegell.soacommon.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    boolean existsByBankAccount(UUID bankAccount);
}
