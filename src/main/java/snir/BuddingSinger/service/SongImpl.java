package snir.BuddingSinger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import snir.BuddingSinger.beans.Genres;
import snir.BuddingSinger.beans.Song;
import snir.BuddingSinger.repostory.SongRep;

import java.util.List;

//Created by sniryosefof on 26 ספט׳
@Service
@RequiredArgsConstructor
public class SongImpl implements SongService{

    private final SongRep songRep;
    @Override
    public List<Song> findAll() {
        return songRep.findAll() ;
    }

    @Override
    public List<Song> findByGenres(Genres genres) {
        return songRep.findByGenres(genres);
    }
}
