package com.asan.eticaret.Urun.Controller;

import com.asan.eticaret.Urun.Dto.*;
import com.itelligence.eticaret.Urun.Dto.*;
import com.asan.eticaret.Urun.Service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urun")
public class UrunController {

    @Autowired
    UrunService urunService;

    @PostMapping(value = "/urunKayit")
    public UrunResponseDto urunKayit(@RequestBody UrunRequestDto urunRequestDto){
      return  urunService.urunKayit(urunRequestDto);
    }
    @PostMapping(value = "/urunfiltre")
    public UrunFiltreResponsetDto urunFiltrele(@RequestBody UrunFiltreRequestDto urunFiltreRequestDto){
        return urunService.urunFiltrele(urunFiltreRequestDto);
    }
    @PostMapping("/favoriekle")
    public FavoriEkleResponseDto favoriEkle(@RequestBody FavoriEkleRequestDto favoriRequestDto){
        return urunService.favoriEkle(favoriRequestDto);
    }

    @PostMapping("/favorilerigoster")
    public FavoriGosterResponseDto favoriGoster(@RequestBody FavoriGosterRequestDto favoriGosterRequestDto){
        return urunService.favoriGoster(favoriGosterRequestDto);
    }

    @PostMapping("/urunsaatis")
    public UrunSatisResponseDto urunSatis(@RequestBody UrunSatisRequestDto urunSatisRequestDto){
        return urunService.urunSatis(urunSatisRequestDto);
    }


}
