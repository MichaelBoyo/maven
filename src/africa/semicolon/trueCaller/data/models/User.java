package africa.semicolon.trueCaller.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@ToString
public class User {

    String firstName;
    String lastName;
    String pin;

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = password;
        this.email = email;
    }
    private boolean setLock;

    public boolean isLocked(String pin){
        if(this.pin.equals(pin)){
            setLock=true;
            return true;
        }
        return false;
    }

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


}
