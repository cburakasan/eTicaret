package com.itelligence.eticaret.Urun.Service;


import com.itelligence.eticaret.Urun.Dto.UrunRequestDto;
import com.itelligence.eticaret.Urun.Dto.UrunResponseDto;
import com.itelligence.eticaret.Urun.Repository.UrunRepository;
import com.itelligence.eticaret.Urun.Repository.UrunUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrunService {

    @Autowired
    UrunRepository urunRepository;

    @Autowired
    UrunUserRepository urunUserRepository;

    public UrunResponseDto urunIslemleri(UrunRequestDto urunRequestDto) {


        return  null;
    }
}
