package snir.BuddingSinger.exception;

import lombok.Getter;

//Created by sniryosefof on 25 ספט׳
@Getter
public enum Err {
   singerIdDontExists("The singer id doesn't exists "),
    TheSingerIdIsWorng("The singer id is wrong"),
    TheSingerEmail("The singer email is exists"),
    InvalidToken("invalid token"),
    TheEmailOrPassword("The  email or password incorrect")
    ;

    private String msg;

    Err(String msg) {
        this.msg = msg;
    }
}
