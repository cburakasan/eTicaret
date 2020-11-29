package com.itelligence.eticaret.Urun.Service;


import com.itelligence.eticaret.Urun.Dto.UrunRequestDto;
import com.itelligence.eticaret.Urun.Dto.UrunResponseDto;
import com.itelligence.eticaret.Urun.EnumModel.EnumKategori;
import com.itelligence.eticaret.Urun.Exception.UrunException;
import com.itelligence.eticaret.Urun.Model.Urun;
import com.itelligence.eticaret.Urun.Repository.UrunRepository;
import com.itelligence.eticaret.Urun.Repository.UrunUserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Log4j
public class UrunService {

    @Autowired
    UrunRepository urunRepository;

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

}
