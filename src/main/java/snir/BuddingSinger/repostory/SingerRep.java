package snir.BuddingSinger.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import snir.BuddingSinger.beans.Singer;

//Created by sniryosefof on 06 ספט׳
public interface SingerRep extends JpaRepository<Singer,Integer> {

    Singer findTop1ByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email,String password);

    @Query(value = "SELECT (first_name) FROM singer where email=?;",nativeQuery = true)
    String findFirstNameByEmail(String email);
}
