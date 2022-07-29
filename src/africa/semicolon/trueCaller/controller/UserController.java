package africa.semicolon.trueCaller.controller;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.requests.ContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;
import africa.semicolon.trueCaller.services.UserService;
import africa.semicolon.trueCaller.services.iUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    public iUserService iUserService = new UserService();
    @PostMapping("/user")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest) {
        return iUserService.register(registerRequest);
    }


    public List<Contact> findContactBelongingTo(String email) {
        return iUserService.findContactsBelongingTo(email);
    }
    @PatchMapping("/user")
    public void addContact(@RequestBody ContactRequest contactRequest) {
        iUserService.addContact(contactRequest);
    }
    @GetMapping("/user")
    public User getUser(@RequestParam String email) {
        return iUserService.getUser(email);
    }
}
