package by.siegell.soacommon.controller;

import by.siegell.soacommon.domain.Contact;
import by.siegell.soacommon.domain.exception.EntityNotFoundException;
import by.siegell.soacommon.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @PostMapping("/")
    public Contact createContact(@RequestBody UUID customerId, @RequestBody String contact) {

        return contactService.save(new Contact(customerId, contact));
    }

    @GetMapping("/")
    public List<Contact> getContactAll() {
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable UUID id) throws EntityNotFoundException {
        return contactService.getById(id);
    }

    @PutMapping("/")
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable UUID id) {
        contactService.deleteById(id);
    }
}