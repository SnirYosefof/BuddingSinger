package snir.BuddingSinger.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Created by sniryosefof on 06 ספט׳
@Entity
@Table(name = "singer")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.PERSIST )
    @Singular
    @ToString.Exclude
    @JsonIgnore
    private List<Song> songs = new ArrayList<>();}
