package de.telran.contacts.repo;

import de.telran.contacts.entity.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactRepoMap implements IContactRepo{

    HashMap<Integer, Contact> contactById;
    private int lastUsedId;

    @Override
    public void save(Contact contact) {
        if (contact.getId() <= 0){
            contact.setId(++lastUsedId);
            contactById.put(lastUsedId, contact);
        } else {
            try {
                Contact oldContact = contactById.get(contact.getId());
                oldContact.setName(contact.getName());
                oldContact.setLastName(contact.getLastName());
                oldContact.setPhoneNumber(contact.getPhoneNumber());
            } catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Contact find(int id) {
        try {
            return contactById.get(id);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contact remove(int id) {
        try {
            return contactById.remove(id);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contactById.values());
    }
}
