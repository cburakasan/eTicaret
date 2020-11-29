package com.asan.eticaret.Urun.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class UrunFiltreResponsetDto implements Serializable {
    private List<UrunDto> urunDtoList;


}
