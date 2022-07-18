package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryImplTest {
    ContactRepository contactRepository;
    Contact contact;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImpl();
        contact =  new Contact("mike",
                "boyo","082828303","koko@mail.com");
    }
    @Test
    public void saveContact_countIncreasesTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void saveContact_findByIdTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("mike",savedContact.getFirstName());
    }
    @Test
    public void saveAndDeleteContactByIDTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("mike",savedContact.getFirstName());

        contactRepository.delete(1);
        assertEquals(0, contactRepository.count());
    }
    @Test
    public void saveAndDeleteContactByObjectTest(){
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("mike",savedContact.getFirstName());

        contactRepository.delete(savedContact);
        assertEquals(0, contactRepository.count());

        assertNull(contactRepository.findById(1));
    }
    @Test
    public void saveAndFindByFirstNameTest(){
        contactRepository.save(contact);
        contactRepository.save(new Contact("mike","kiki","",""));
        assertEquals(2, contactRepository.count());
        Contact savedContact = contactRepository.findById(1);
        assertEquals("mike",savedContact.getFirstName());

        assertEquals(2,contactRepository.findByFirstName("mike").size());
        assertEquals(1,contactRepository.findByLastName("kiki").size());
    }


}