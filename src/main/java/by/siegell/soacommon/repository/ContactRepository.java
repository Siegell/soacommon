package by.siegell.soacommon.repository;

import by.siegell.soacommon.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
    List<Contact> findAllByCustomerId(UUID customerId);
}
