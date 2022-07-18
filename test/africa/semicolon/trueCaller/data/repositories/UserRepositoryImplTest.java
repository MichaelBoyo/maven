package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepository userRepository;
    User user;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        user = new User("kiki");
    }

    @Test
    void saveTest() {
        userRepository.save(user);
        assertEquals(1,userRepository.count());
    }

    @Test
    void deleteByObjectTest() {
        userRepository.save(user);
        userRepository.delete(userRepository.findById(1));
        assertEquals(0,userRepository.count());
    }

    @Test
    void DeleteByIdTest() {
        userRepository.save(user);
        userRepository.delete(userRepository.findById(1).getId());
        assertEquals(0,userRepository.count());
    }

    @Test
    void findByIdTest() {
        userRepository.save(user);

        assertEquals("kiki",userRepository.findById(1).getEmail());
    }

    @Test
    void findByEmailTest() {
        userRepository.save(user);
        assertEquals(1,userRepository.findByEmail("kiki").size());
    }

    @Test
    void findAllTest() {
        userRepository.save(user);
        userRepository.save(new User("amos"));
        assertEquals(2,userRepository.findAll().size());

    }

    @Test
    void countTest() {
        userRepository.save(user);
        userRepository.save(new User("amos"));
        assertEquals(2,userRepository.count());
    }
    @Test
    void updateTest(){
        userRepository.save(user);
        var savedUser = userRepository.findById(1);

        savedUser.setEmail("boyo");
        var newU = userRepository.save(savedUser);

        assertEquals(1,userRepository.count());
        assertEquals(1,newU.getId());
        assertEquals("boyo",userRepository.findById(1).getEmail());
    }
}