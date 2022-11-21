package snir.BuddingSinger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import snir.BuddingSinger.beans.Singer;
import snir.BuddingSinger.exception.Err;
import snir.BuddingSinger.exception.SystemException;
import snir.BuddingSinger.repostory.SingerRep;
import snir.BuddingSinger.repostory.SongRep;
import snir.BuddingSinger.securty.TokenManger;

import java.util.UUID;

//Created by sniryosefof on 27 ספט׳
@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService{
    private final SingerRep singerRep;
    private final TokenManger tokenManger;


    @Override
    public void register(String firstName, String lastName, String email, String password) throws SystemException {
        Singer singer= Singer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
        if (singerRep.existsByEmail(email)){
            throw new SystemException(Err.TheSingerEmail);
        }
        singerRep.save(singer);
    }

    @Override
    public UUID login(String email, String password) throws SystemException {
        if (!singerRep.existsByEmailAndPassword(email, password)){
            throw new SystemException(Err.TheEmailOrPassword);
        }
        return tokenManger.add(email, password);
    }
}
