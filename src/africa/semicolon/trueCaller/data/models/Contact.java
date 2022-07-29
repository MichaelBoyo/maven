package africa.semicolon.trueCaller.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
