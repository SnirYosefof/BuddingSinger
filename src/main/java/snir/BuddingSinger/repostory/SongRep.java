package snir.BuddingSinger.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import snir.BuddingSinger.beans.Genres;
import snir.BuddingSinger.beans.Song;

import java.util.List;

//Created by sniryosefof on 06 ספט׳
public interface SongRep extends JpaRepository<Song,Integer> {

    boolean existsBySingerIdAndId(int SingerId,int songId);

    List<Song> findBySingerId(int singerId);

    int countBySingerId(int singerId);

    List<Song> findByGenres(Genres genres);
}
