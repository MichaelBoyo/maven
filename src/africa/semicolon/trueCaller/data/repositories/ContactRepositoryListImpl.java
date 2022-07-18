package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactRepositoryListImpl implements ContactRepository {
    private List<Contact> contacts = new ArrayList<>();
    private int counter;
    @Override
    public Contact save(Contact contact) {
        if(contact.getId()==0){
            counter++;
            contact.setId(counter);
            contacts.add(contact);
            return contact;
        }
        delete(contact.getId());
        contacts.add(contact);

        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public void delete(int id) {
        contacts.remove(id-1);
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id-1);
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return contacts.stream().filter((contact -> contact.getFirstName()
                .equalsIgnoreCase(firstName))).collect(Collectors.toList());
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        return contacts.stream().filter((contact -> contact.getLastName()
                .equalsIgnoreCase(lastName))).collect(Collectors.toList());
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
