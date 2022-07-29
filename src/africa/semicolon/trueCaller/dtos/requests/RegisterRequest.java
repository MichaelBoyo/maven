package africa.semicolon.trueCaller.dtos.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    String firstName;
    String lastName;
    String email;
    String pin;
}
