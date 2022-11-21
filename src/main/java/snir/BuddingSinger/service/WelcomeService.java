package snir.BuddingSinger.service;

import snir.BuddingSinger.exception.SystemException;

import java.util.UUID;

//Created by sniryosefof on 27 ספט׳
public interface WelcomeService {
    void register(String firstName,String lastName,String email, String password) throws SystemException;
    UUID login(String email, String password) throws SystemException;
}
