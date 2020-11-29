package com.asan.eticaret.Urun.Dto;

import com.asan.eticaret.Urun.EnumKategori.EnumKategori;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UrunRequestDto implements Serializable {
    private Double fiyat;
    private String marka;
    private String model;
    private Date eklenmeTarihi;
    private EnumKategori kategori;

}
