package africa.semicolon.trueCaller.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userEmail;
}
