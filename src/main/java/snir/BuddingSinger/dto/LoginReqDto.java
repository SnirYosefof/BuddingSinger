package snir.BuddingSinger.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import java.util.UUID;

//Created by sniryosefof on 27 ספט׳
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginReqDto {

    @Email
    private String email;
    @Length(min = 4, max = 10)
    private String password;
}