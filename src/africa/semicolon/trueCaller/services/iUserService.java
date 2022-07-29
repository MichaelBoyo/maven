package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.requests.ContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;

import java.util.List;

public interface iUserService {
    RegisterResponse register(RegisterRequest registerRequest);

    int getNumberOfUsers();

    List<Contact> findContactsBelongingTo(String email);

    void addContact(ContactRequest contactRequest);

    User getUser(String email);
}
