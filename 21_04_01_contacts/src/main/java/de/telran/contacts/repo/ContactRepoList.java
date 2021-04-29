package de.telran.contacts.repo;

import de.telran.contacts.entity.Contact;
import de.telran.contacts.service.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactRepoList implements IContactRepo{

    private final ArrayList<Contact> contacts;
    private int lastUsedId;
    private final ContactService contactService;

    public ContactRepoList(ArrayList<Contact> contacts, int lastUsedId, ContactService contactService) {
        this.contacts = contacts;
        this.lastUsedId = lastUsedId;
        this.contactService = contactService;
    }

    @Override
    public void save(Contact contact) {
        if (contact.getId() <= 0){
            contact.setId(++lastUsedId);
            contacts.add(contact);
        } else {
            Contact oldContact = contacts
                    .stream()
                    .filter(cont -> cont.getId() == contact.getId())
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            oldContact.setName(contact.getName());
            oldContact.setLastName(contact.getLastName());
            oldContact.setPhoneNumber(contact.getPhoneNumber());
        }
    }

    @Override
    public Contact find(int id) {
        return contacts.stream()
                .filter(con -> con.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Contact remove(int id) {
        Contact contact = find(id);
        contacts.removeIf(cont -> cont.getId() == id);
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        return contactService.getAll();
    }
}
