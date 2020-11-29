package com.itelligence.eticaret.Urun.Dto;

import com.itelligence.eticaret.Urun.EnumModel.EnumKategori;
import lombok.Data;

import java.util.Date;

@Data
public class UrunRequestDto {
    private Double fiyat;
    private String marka;
    private String model;
    private Date eklenmeTarihi;
    private EnumKategori kategori;

}
