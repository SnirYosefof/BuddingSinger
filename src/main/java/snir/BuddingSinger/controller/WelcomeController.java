package snir.BuddingSinger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import snir.BuddingSinger.dto.LoginReqDto;
import snir.BuddingSinger.dto.LoginResDto;
import snir.BuddingSinger.dto.RegisterReqDto;
import snir.BuddingSinger.exception.SystemException;
import snir.BuddingSinger.repostory.SingerRep;
import snir.BuddingSinger.service.WelcomeService;

import javax.validation.Valid;
import java.util.UUID;

//Created by sniryosefof on 02 אוק׳
@RestController
@RequestMapping("api/welcome")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WelcomeController {

    private final WelcomeService welcomeService;
    private final SingerRep singerRep;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterReqDto registerReqDto) throws SystemException {
        String email = registerReqDto.getEmail();
        String password = registerReqDto.getPassword();
        String firstName = registerReqDto.getFirstName();
        String lastName = registerReqDto.getLastName();
        welcomeService.register(firstName, lastName, email, password);

    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    private LoginResDto login(@Valid @RequestBody LoginReqDto loginReqDto) throws SystemException {
        String email = loginReqDto.getEmail();
        String password = loginReqDto.getPassword();
        String firstName = singerRep.findFirstNameByEmail(email);
        UUID token = welcomeService.login(email, password);

        return new LoginResDto(token, email,firstName);
    }
}


