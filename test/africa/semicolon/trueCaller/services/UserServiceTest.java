package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private iUserService userService;
    @BeforeEach
    public void setUp(){
       userService =  new UserService();
    }
    @Test
    public void registerTest(){

        RegisterRequest request = new RegisterRequest();
        request.setEmail("email");
        request.setFirstName("firstName");
        request.setLastName("lastName");
        request.setPassword("password");

        userService.register(request);
        assertEquals(1, userService.getNumberOfUsers());
    }
    @Test
    public void duplicateEmailThrowsException(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("email");
        request.setFirstName("firstName");
        request.setLastName("lastName");
        request.setPassword("password");

        var resp = userService.register(request);
        assertEquals(resp.getFirstName(), "firstName");
        assertThrows(UserExistsException.class, ()->userService.register(request));
        assertEquals(1, userService.getNumberOfUsers());
    }
}