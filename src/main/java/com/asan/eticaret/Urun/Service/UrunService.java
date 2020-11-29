package com.asan.eticaret.Urun.Service;


import com.asan.eticaret.Urun.Dto.*;
import com.asan.eticaret.Urun.EnumKategori.EnumKategori;
import com.asan.eticaret.Urun.Repository.UrunRepository;
import com.asan.eticaret.Urun.Model.Favori;
import com.asan.eticaret.Urun.Model.Urun;
import com.asan.eticaret.Urun.Repository.FavoriRepository;
import com.asan.eticaret.Urun.Repository.UrunUserRepository;
import com.asan.eticaret.User.Model.User;
import com.asan.eticaret.User.Repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j
public class UrunService {

    @Autowired
    UrunRepository urunRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FavoriRepository favoriRepository;

    @Autowired
    UrunUserRepository urunUserRepository;

    public UrunResponseDto urunKayit(UrunRequestDto urunRequestDto) {
        UrunResponseDto urunResponseDto = new UrunResponseDto();
        try {
            Double fiyat = urunRequestDto.getFiyat();
            String marka = urunRequestDto.getMarka();
            String model = urunRequestDto.getModel();
            Date eklenmeTarihi = urunRequestDto.getEklenmeTarihi();
            EnumKategori kategori = urunRequestDto.getKategori();
            Urun urun = new Urun();
            urun.setFiyat(fiyat);
            urun.setMarka(marka);
            urun.setModel(model);
            urun.setEklenmeTarihi(eklenmeTarihi);
            urun.setKategori(kategori);
            urun = urunRepository.save(urun);
            Long id = urun.getId();
            urunResponseDto.setUrunKayitDurumu(true);
            urunResponseDto.setUrunId(id);

//            throw new UrunException("Urun kaydi basarisiz", new RuntimeException());
        } catch (Exception e) {
            e.getMessage();
            log.error("Kayit islemi sirasinda bir hata olustu ex="+ e.getMessage(),e);
            urunResponseDto.setUrunKayitDurumu(false);


        }


        return urunResponseDto;
    }


    public UrunFiltreResponsetDto urunFiltrele(UrunFiltreRequestDto urunFiltreRequestDto) {
        UrunFiltreResponsetDto urunFiltreResponsetDto = new UrunFiltreResponsetDto();
        List<UrunDto> urunDtoList = new ArrayList<>();
        Double requstEnDusukFiyat = urunFiltreRequestDto.getEnDusukFiyat();
        Double requestEnYuksekFiyat = urunFiltreRequestDto.getEnYuksekFiyat();
        EnumKategori requestKategori = urunFiltreRequestDto.getKategori();
        String requestMarka = urunFiltreRequestDto.getMarka();
        String requestModel = urunFiltreRequestDto.getModel();
        List<Urun> urunList = urunRepository.findAllByKategoriOrMarkaOrModelOrFiyatIsBetween(requestKategori, requestMarka, requestModel, requstEnDusukFiyat, requestEnYuksekFiyat);
        for (Urun urun : urunList) {
            UrunDto urunDto =new UrunDto();
            urunDto.setKategori(urun.getKategori());
            urunDto.setMarka(urun.getMarka());
            urunDto.setModel(urun.getModel());
            urunDto.setFiyat(urun.getFiyat());
            urunDtoList.add(urunDto);
        }
        urunFiltreResponsetDto.setUrunDtoList(urunDtoList);


        return urunFiltreResponsetDto;
    }

    public FavoriEkleResponseDto favoriEkle(FavoriEkleRequestDto favoriRequestDto) {
        FavoriEkleResponseDto favoriResponseDto = new FavoriEkleResponseDto();
        try {
            Long urunId = favoriRequestDto.getUrunId();
            Long userId = favoriRequestDto.getUserId();

            Optional<Urun> urunOptional = urunRepository.findById(urunId);
            Urun urun = urunOptional.get();

            Optional<User> userOptional = userRepository.findById(userId);
            User user = userOptional.get();

            Favori favori = new Favori();
            favori.setUrun(urun);
            favori.setUser(user);
            favoriRepository.save(favori);

        }catch (Exception e){
            String message = e.getMessage();
            log.error(message+"Favori ekleme isleminde bir hata olustu");
            favoriResponseDto.setHataMesaji(message);
            return favoriResponseDto;
        }

        favoriResponseDto.setSuccsessMessage("Favoriye ekleme islemi basarili");


        return favoriResponseDto;
    }

    public FavoriGosterResponseDto favoriGoster(FavoriGosterRequestDto favoriGosterRequestDto) {
        FavoriGosterResponseDto favoriGosterResponseDto = new FavoriGosterResponseDto();
        List<UrunDto> urunDtoList = new ArrayList<>();

        Long userId = favoriGosterRequestDto.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();

        List<Favori> favoriList = favoriRepository.findAllByUser(user);
        for (Favori favori : favoriList) {
            Urun urun = favori.getUrun();
            UrunDto urunDto= new UrunDto();
            urunDto.setMarka(urun.getMarka());
            urunDto.setModel(urun.getModel());
            urunDto.setFiyat(urun.getFiyat());
            urunDto.setKategori(urunDto.getKategori());
            urunDtoList.add(urunDto);
        }
        favoriGosterResponseDto.setFavoriList(urunDtoList);

        return favoriGosterResponseDto;
    }

    public UrunSatisResponseDto urunSatis(UrunSatisRequestDto urunSatisRequestDto) {
        UrunSatisResponseDto urunSatisResponseDto = new UrunSatisResponseDto();
        List<UrunDto> urunDtoList = new ArrayList<>();
        Long userId = urunSatisRequestDto.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();
        List<Urun> urunList = urunUserRepository.findAllByUser(user);
        for (Urun urun : urunList) {
            UrunDto urunDto = new UrunDto();
            urunDto.setMarka(urun.getMarka());
            urunDto.setModel(urun.getModel());
            urunDto.setFiyat(urun.getFiyat());
            urunDto.setKategori(urunDto.getKategori());
            urunDtoList.add(urunDto);
        }
        urunSatisResponseDto.setUrunList(urunDtoList);

        return urunSatisResponseDto;
    }
}
