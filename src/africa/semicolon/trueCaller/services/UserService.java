package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryMapImpl;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.ContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import africa.semicolon.trueCaller.utils.Mapper;

import java.util.List;

public class UserService implements iUserService {

    private  UserRepository userRepository;
    private ContactRepository contactRepository;
    public UserService(){
        userRepository = new UserRepositoryImpl();
        contactRepository = new ContactRepositoryMapImpl();
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if(userRepository.findAll().
                stream().anyMatch((user -> user.getEmail().equals(request.getEmail())))){
            throw new UserExistsException("user already exists");
        }
        User user = new User(request.getFirstName(), request.getLastName(),
                request.getPin(),request.getEmail());
        userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setFirstName(user.getFirstName());
        registerResponse.setLastName(user.getLastName());
        return registerResponse;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public List<Contact> findContactsBelongingTo(String email) {

        return userRepository.findUserByEmail(email).getContacts();
    }

    @Override
    public void addContact(ContactRequest contactRequest) {
        Contact contact =Mapper.map(contactRequest,new Contact());
        var savedContact = contactRepository.save(contact);
        var user = userRepository.findUserByEmail(contactRequest.getUserEmail());
        user.getContacts().add(savedContact);
        userRepository.save(user);

    }

    @Override
    public User getUser(String email) {
        return userRepository.findUserByEmail(email);
    }
}
