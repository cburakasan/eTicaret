package com.asan.eticaret.Urun.Dto;

import com.asan.eticaret.Urun.EnumKategori.EnumKategori;
import lombok.Data;

import java.io.Serializable;

@Data
public class UrunDto implements Serializable {
    private Long id;
    private Double fiyat;
    private String marka;
    private  String model;
    private EnumKategori kategori;

}
