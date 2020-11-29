package com.asan.eticaret.Urun.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UrunResponseDto implements Serializable {
    private boolean urunKayitDurumu;
    private Long urunId;

}
