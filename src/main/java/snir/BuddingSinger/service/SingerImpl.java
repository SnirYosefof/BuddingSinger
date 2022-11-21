package snir.BuddingSinger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import snir.BuddingSinger.beans.Song;
import snir.BuddingSinger.exception.Err;
import snir.BuddingSinger.exception.SystemException;
import snir.BuddingSinger.repostory.SingerRep;
import snir.BuddingSinger.repostory.SongRep;

import java.util.List;

//Created by sniryosefof on 25 ספט׳
@Service
@RequiredArgsConstructor
public class SingerImpl implements SingerService {
    private final SingerRep singerRep;
    private final SongRep songRep;

    @Override
    public Song addSong(int singerId, Song song) throws SystemException {
        song.setSinger(singerRep.findById(singerId).orElseThrow(()->new SystemException(Err.singerIdDontExists)));
        return songRep.save(song);
    }

    @Override
    public Song updateSong(int singerId, Song song) throws SystemException {
        song.setSinger(singerRep.findById(singerId).orElseThrow(()->new SystemException(Err.singerIdDontExists)));
        song.setId(song.getId());
        if (!songRep.existsBySingerIdAndId(singerId, song.getId())){
            throw new SystemException(Err.TheSingerIdIsWorng);
        }
        return songRep.saveAndFlush(song);
    }

    @Override
    public void deleteSong(int singerId, int songId) throws SystemException {
        if (!songRep.existsBySingerIdAndId(singerId,songId)){
            throw new SystemException(Err.TheSingerIdIsWorng);
        }
        songRep.deleteById(songId);
    }

    @Override
    public List<Song> getAllSingerSongs(int singerId) {
        return songRep.findBySingerId(singerId);
    }

    @Override
    public int count(int singerId) {
        return songRep.countBySingerId(singerId);
    }
}
