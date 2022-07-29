package africa.semicolon.trueCaller.services;


import africa.semicolon.trueCaller.data.models.Contact;

public interface iContactService {
    Contact saveContact(Contact contact);
    int getNumberOfContacts();
}
