package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.requests.ContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;

public class Mapper {
    public static void map(Contact contact, Contact newContact) {
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setEmail(contact.getEmail());
        newContact.setPhoneNumber(contact.getPhoneNumber());
    }
    public static void map(RegisterRequest registerRequest, User newUserToAdd) {
        newUserToAdd.setFirstName(registerRequest.getFirstName());
        newUserToAdd.setLastName(registerRequest.getLastName());
        newUserToAdd.setEmail(registerRequest.getEmail());
        newUserToAdd.setPin(registerRequest.getPin());
    }

    public static Contact map(ContactRequest contactRequest, Contact newContact) {
        newContact.setFirstName(contactRequest.getFirstName());
        newContact.setLastName(contactRequest.getLastName());
        newContact.setEmail(contactRequest.getEmail());
        newContact.setPhoneNumber(contactRequest.getPhoneNumber());
        return newContact;
    }
}
