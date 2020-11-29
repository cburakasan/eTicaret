package com.asan.eticaret.User.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponseDto implements Serializable {
    private String hataMessage;
    private Long id;
    private String username;
    private String password;
    private String email;
    private String gsm;

}

