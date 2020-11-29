package com.asan.eticaret.Urun.Repository;

import com.asan.eticaret.Urun.Model.Urun;
import com.asan.eticaret.Urun.Model.UrunUser;
import com.asan.eticaret.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrunUserRepository extends JpaRepository<UrunUser,Long> {
    List<Urun> findAllByUser(User user);
}
