package com.itelligence.eticaret.User.Dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private String hataMessage;
    private Long id;
    private String username;
    private String password;
    private String email;
    private String gsm;

}

