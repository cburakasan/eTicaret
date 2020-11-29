package com.asan.eticaret.Urun.Repository;

import com.asan.eticaret.Urun.Model.Favori;
import com.asan.eticaret.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriRepository extends JpaRepository<Favori,Long> {
    List<Favori> findAllByUser(User user);

}
