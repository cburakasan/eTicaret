package com.itelligence.eticaret.Urun.Exception;

import lombok.Data;


@Data
public class UrunException  extends Exception{
    private String message;

    public UrunException(String message, Throwable throwable){
        super(message,throwable);
        this.message=message;
    }


}
