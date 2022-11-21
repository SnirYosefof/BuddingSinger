package snir.BuddingSinger.clr;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import snir.BuddingSinger.beans.Genres;
import snir.BuddingSinger.beans.Singer;
import snir.BuddingSinger.beans.Song;
import snir.BuddingSinger.factory.Art;
import snir.BuddingSinger.repostory.SingerRep;
import snir.BuddingSinger.repostory.SongRep;
import snir.BuddingSinger.service.SingerService;
import snir.BuddingSinger.service.SongService;
import snir.BuddingSinger.service.WelcomeService;

import java.sql.Date;
import java.time.LocalDate;

//Created by sniryosefof on 06 ספט׳
@Component
@Order(1)
@RequiredArgsConstructor
public class Test implements CommandLineRunner {

    private final SingerRep singerRep;
    private final SongRep songRep;
    private final WelcomeService welcomeService;
    private final SingerService singerService;
    private final SongService songService;

    @Override
    public void run(String... args) throws Exception {
        Art.ArtSingers();

        Singer singer1 = Singer.builder()
                .firstName("tuna")
                .email("tuna@gmail.com")
                .password("123123")
                .build();
        Singer singer2 = Singer.builder()
                .firstName("nunu")
                .email("nunu@gmail.com")
                .password("123123")
                .build();
//
        Art.ArtSongs();
        Song song1 = Song.builder()
                .name("Sahara")
                .singerName(singer1.getFirstName())
                .genres(Genres.Rap)
                .length("4:05")
                .releaseDate(Date.valueOf(LocalDate.of(2021, 12, 17)))
                .link("https://www.youtube.com/watch?v=dZWlObNQoZ4")
                .singer(singer1)
                .build();
        Song song2 = Song.builder()
                .name("cute boy")
                .singerName(singer2.getFirstName())
                .genres(Genres.Pop)
                .length("3:27")
                .releaseDate(Date.valueOf(LocalDate.of(2022, 6, 6)))
                .link("https://www.youtube.com/watch?v=_6qklnKfiUA")
                .singer(singer2)
                .build();
        Song song3 = Song.builder()
                .name("Moshe")
                .singerName(singer1.getFirstName())
                .genres(Genres.Rap)
                .length("4:05")
                .releaseDate(Date.valueOf(LocalDate.of(2021, 12, 17)))
                .link("https://www.youtube.com/watch?v=dZWlObNQoZ4")
                .genres(Genres.Rap)
                .singer(singer2)
                .build();
        singerRep.save(singer1);
        singerRep.save(singer2);
        songRep.save(song1);
        System.out.println(songRep.existsBySingerIdAndId(1, 1));
        songRep.findBySingerId(singer1.getId()).forEach(System.out::println);
        singerRep.findAll().forEach(System.out::println);
        System.out.println(songRep.countBySingerId(2));

//        welcomeService.register("nono","","nono@gmail.com","123123");
        singerService.addSong(2, song2);
        singerService.addSong(2, song3);
        System.out.println("@@@@@get all song@@@@@@");
        songService.findAll().forEach(System.out::println);
        System.out.println("@@@@@get all grebes@@@@@@");
        songService.findByGenres(Genres.Rap).forEach(System.out::println);
        System.out.println("@@@@@get all singer songs@@@@@@");
        singerService.getAllSingerSongs(2).forEach(System.out::println);
        System.out.println("@@@@@delete@@@@@@");
        singerService.deleteSong(singer2.getId(), 3);
        System.out.println("@@@@@count@@@@@@");
        System.out.println(singerService.count(singer2.getId()));



    }
}
