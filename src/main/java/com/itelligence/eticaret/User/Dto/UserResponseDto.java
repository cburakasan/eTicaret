package com.itelligence.eticaret.User.Dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private String username;
    private String password;
    private String email;
    private Integer gsm;
    private String message;

}
