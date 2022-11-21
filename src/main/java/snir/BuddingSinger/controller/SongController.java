package snir.BuddingSinger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import snir.BuddingSinger.beans.Genres;
import snir.BuddingSinger.beans.Song;
import snir.BuddingSinger.service.SongService;

import java.util.List;

//Created by sniryosefof on 03 אוק׳
@RestController
@RequestMapping("api/song")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SongController {
    private final SongService songService;

    @GetMapping()
    public List<Song> findAllSong() {
        return songService.findAll();
    }

    @GetMapping("songGenres")
    public List<Song> findByGenres(@RequestParam Genres genres) {
        return songService.findByGenres(genres);
    }
}
