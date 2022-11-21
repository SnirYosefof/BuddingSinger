package snir.BuddingSinger.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

//Created by sniryosefof on 06 ספט׳
@Entity
@Table(name = "song")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String singerName;
    private String name;
    private String length;
    private String link;
    private Date releaseDate;
    @Enumerated(EnumType.STRING)
    private Genres genres;
    @ManyToOne
    private Singer singer;
}
