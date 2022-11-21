package snir.BuddingSinger.service;

import snir.BuddingSinger.beans.Genres;
import snir.BuddingSinger.beans.Song;

import java.util.List;

//Created by sniryosefof on 26 ספט׳
public interface SongService {

    List<Song> findAll();

    List<Song> findByGenres(Genres genres);
}
