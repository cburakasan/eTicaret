package com.asan.eticaret.User.Dto;


import java.io.Serializable;

public class UserDto implements Serializable {
    private String username;
    private String password;
    private String email;
    private Integer gsm;

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gsm=" + gsm +
                '}';
    }
}
