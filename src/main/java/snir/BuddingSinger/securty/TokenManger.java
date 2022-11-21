package snir.BuddingSinger.securty;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import snir.BuddingSinger.beans.Singer;
import snir.BuddingSinger.exception.Err;
import snir.BuddingSinger.exception.SystemException;
import snir.BuddingSinger.repostory.SingerRep;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

//Created by sniryosefof on 26 ספט׳
@Service
@RequiredArgsConstructor
public class TokenManger {

    private final Map<UUID,Information> map;
    private final SingerRep singerRep;

    public UUID add(String email,String password){
        Singer singerFromDb=singerRep.findTop1ByEmail(email);
        removePreviousInstances(singerFromDb.getId());
        Information information= new Information();
        information.setLocalDateTime(LocalDateTime.now());
        information.setSingerId(singerFromDb.getId());

        UUID token= UUID.randomUUID();
        map.put(token,information);
        return token;
    }

    @Scheduled(fixedRate=1000*60*30)
    public void deleteExpiredTokenAfter30Min(){
        map.entrySet().removeIf(ins->ins.getValue().getLocalDateTime().isAfter(LocalDateTime.now().plusMinutes(30)));
    }


    public int getUserId(UUID token) throws SystemException {
        Information information=map.get(token);
        if (information==null){
            throw new SystemException(Err.InvalidToken);
        }
        return information.getSingerId();
    }
    public void removePreviousInstances(int userId){
        map.entrySet().removeIf(ins-> ins.getValue().getSingerId()==userId);
    }
}
