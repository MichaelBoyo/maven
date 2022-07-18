package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.*;
import java.util.stream.Collectors;

public class ContactRepositoryMapImpl implements ContactRepository{
    private int counter;
    private Map<Integer, Contact> contacts = new HashMap<>();
    @Override
    public Contact save(Contact contact) {
        if(contact.getId()== 0){
            counter++;
            contact.setId(counter);
            contacts.put(counter,contact);
        }

        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact.getId());
    }

    @Override
    public void delete(int id) {
        contacts.remove(findById(id).getId());
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id);
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return contacts.values().stream()
                .filter((contact -> contact.getFirstName().equalsIgnoreCase(firstName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        return contacts.values().stream()
                .filter((contact -> contact.getLastName().equalsIgnoreCase(lastName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> findAll() {
        return (List<Contact>) contacts.values();
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
