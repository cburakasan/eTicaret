package com.itelligence.eticaret.Urun.Controller;

import com.itelligence.eticaret.Urun.Dto.UrunRequestDto;
import com.itelligence.eticaret.Urun.Dto.UrunResponseDto;
import com.itelligence.eticaret.Urun.Service.UrunService;
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
}
