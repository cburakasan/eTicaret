package com.asan.eticaret.Urun.Dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UrunSatisResponseDto implements Serializable {

    private List<UrunDto> urunList;



}
