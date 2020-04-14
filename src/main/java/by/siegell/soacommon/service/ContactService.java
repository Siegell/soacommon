package by.siegell.soacommon.service;

import by.siegell.soacommon.domain.Contact;
import by.siegell.soacommon.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContactService extends EntityCRUDService<Contact, UUID, ContactRepository> {
    private ContactRepository repository;

    @Override
    ContactRepository getRepository() {
        return repository;
    }

    public List<Contact> findAllByCustomerId(UUID customerId) {
        return repository.findAllByCustomerId(customerId);
    }
}
