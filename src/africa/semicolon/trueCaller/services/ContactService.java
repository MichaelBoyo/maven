package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.dtos.responses.ContactResponse;
import africa.semicolon.trueCaller.utils.Mapper;

public class ContactService implements iContactService{
    private ContactRepository contactRepository;
    private ContactResponse contactResponse = new ContactResponse();

    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact saveContact(Contact contact) {
        Contact addNewContact = new Contact();
        Mapper.map(contact,addNewContact);
        contactRepository.save(addNewContact);
        var response = contactResponse.getMessage();
        return addNewContact;
    }

    @Override
    public int getNumberOfContacts() {
        return contactRepository.count();
    }
}
