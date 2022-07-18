package africa.semicolon.trueCaller.data.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String email;
    private List<Contact> contacts = new ArrayList<>();

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
