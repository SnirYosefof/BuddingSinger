package snir.BuddingSinger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import snir.BuddingSinger.beans.Song;
import snir.BuddingSinger.exception.SystemException;
import snir.BuddingSinger.repostory.SingerRep;
import snir.BuddingSinger.securty.TokenManger;
import snir.BuddingSinger.service.SingerService;

import java.util.List;
import java.util.UUID;

//Created by sniryosefof on 02 אוק׳
@RestController
@RequestMapping("api/singer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SingerController {
    private final SingerService singerService;
    private final TokenManger tokenManger;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Song addSong(@RequestHeader("Authorization") UUID token, @RequestBody Song song) throws SystemException {
        int singerId = tokenManger.getUserId(token);
        return singerService.addSong(singerId, song);
    }

    @PutMapping("/{songId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Song updateSong(@RequestHeader("Authorization") UUID token, @PathVariable int songId, @RequestBody Song song) throws SystemException {
        song.setId(songId);
        int singerId = tokenManger.getUserId(token);
        return singerService.updateSong(singerId, song);
    }

    @DeleteMapping("/{songId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteSong(@RequestHeader("Authorization") UUID token, @PathVariable int songId) throws SystemException {
    int singerId= tokenManger.getUserId(token);
    singerService.deleteSong(singerId,songId);
    }
    @GetMapping("/singerSong")
    public List<Song> getAllSingerSong(@RequestHeader("Authorization") UUID token) throws SystemException {
        int singerId =tokenManger.getUserId(token);
        return singerService.getAllSingerSongs(singerId);
    }
    @GetMapping("/count")
    public int count(@RequestHeader ("Authorization") UUID token) throws SystemException {
        int singerId =tokenManger.getUserId(token);
        return singerService.count(singerId);
    }
}
