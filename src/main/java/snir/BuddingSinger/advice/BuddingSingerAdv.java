package snir.BuddingSinger.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import snir.BuddingSinger.exception.SystemException;

//Created by sniryosefof on 03 אוק׳
@RestControllerAdvice
public class BuddingSingerAdv {


    @ExceptionHandler(value = {SystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrAdv handlerError(Exception e) {
        return new ErrAdv("System err", e.getMessage());
    }

}

//
