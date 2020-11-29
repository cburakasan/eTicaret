package com.asan.eticaret.User.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequestDto implements Serializable {
    private String username;
    private String password;
    private String email;
    private String  gsm;
}
