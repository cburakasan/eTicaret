package com.itelligence.eticaret.User.Dto;


public class UserDto {
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
