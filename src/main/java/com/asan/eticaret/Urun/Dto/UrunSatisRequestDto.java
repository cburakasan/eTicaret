package com.asan.eticaret.Urun.Dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UrunSatisRequestDto implements Serializable {
    private Long id;
    private Long urunId;
    private Long userId;


}
