package snir.BuddingSinger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

//Created by sniryosefof on 27 ספט׳
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterReqDto {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Length(min = 4,max = 10)
    private String password;
}
