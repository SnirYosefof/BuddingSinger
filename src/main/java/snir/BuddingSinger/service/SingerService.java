package snir.BuddingSinger.service;

import snir.BuddingSinger.beans.Song;
import snir.BuddingSinger.exception.SystemException;

import java.util.List;

//Created by sniryosefof on 24 ספט׳
public interface SingerService {

    Song addSong(int singerId, Song song) throws SystemException;

    Song updateSong(int singerId, Song song) throws SystemException;

    void deleteSong(int singerId, int songId) throws SystemException;

    List<Song> getAllSingerSongs(int singerId);

    int count(int singerId);
}
