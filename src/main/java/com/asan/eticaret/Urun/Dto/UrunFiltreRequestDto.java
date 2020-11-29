package com.asan.eticaret.Urun.Dto;

import com.asan.eticaret.Urun.EnumKategori.EnumKategori;
import lombok.Data;

import java.io.Serializable;

@Data
public class UrunFiltreRequestDto implements Serializable {
    private Double enDusukFiyat;
    private Double enYuksekFiyat;
    private String marka;
    private String model;
    private EnumKategori kategori;

}
