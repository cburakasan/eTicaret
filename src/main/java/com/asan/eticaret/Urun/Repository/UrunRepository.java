package com.asan.eticaret.Urun.Repository;

import com.asan.eticaret.Urun.EnumKategori.EnumKategori;
import com.asan.eticaret.Urun.Model.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrunRepository extends JpaRepository <Urun,Long> {
    List<Urun> findAllByKategoriOrMarkaOrModelOrFiyatIsBetween(EnumKategori enumKategori, String marka, String model, Double dusukFiyat, Double yuksekFiyat);

}
