package snir.BuddingSinger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Created by sniryosefof on 27 ספט׳
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResDto {
    private UUID token;
    private String email;
    private String firstName;
}
