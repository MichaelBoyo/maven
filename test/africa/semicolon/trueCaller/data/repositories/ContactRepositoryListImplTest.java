package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryListImplTest {
    ContactRepository contactRepository;
    Contact contact;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryListImpl();
        contact =  new Contact("mike",
                "boyo","082828303","koko@mail.com");
    }
    @Test
    public void saveAndUpdateTest(){
        contactRepository.save(contact);
        Contact savedContact = contactRepository.findById(1);
        savedContact.setEmail("mikey");
        contactRepository.save(savedContact);

        assertEquals("mikey",contactRepository.findById(1).getEmail());
        assertEquals(1, contactRepository.count());

    }
}