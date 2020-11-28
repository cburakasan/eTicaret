package com.itelligence.eticaret.User.Dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String  gsm;
}
