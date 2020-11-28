package com.itelligence.eticaret.Urun.Controller;

import com.itelligence.eticaret.Urun.Dto.UrunRequestDto;
import com.itelligence.eticaret.Urun.Dto.UrunResponseDto;
import com.itelligence.eticaret.Urun.Service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urun")
public class UrunController {

    @Autowired
    UrunService urunService;

    public UrunResponseDto urunIslemleri(@RequestBody UrunRequestDto urunRequestDto){
      return  urunService.urunIslemleri(urunRequestDto);
    }
}
