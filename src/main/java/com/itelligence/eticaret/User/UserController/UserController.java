package com.itelligence.eticaret.User.UserController;


import com.itelligence.eticaret.User.Dto.UserRequestDto;
import com.itelligence.eticaret.User.Dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserResponseDto userKayit(@RequestBody UserRequestDto userRequestDto) {
    return null;


    }


}
