package com.itelligence.eticaret.User.Controller;


import com.itelligence.eticaret.User.Dto.UserRequestDto;
import com.itelligence.eticaret.User.Dto.UserResponseDto;
import com.itelligence.eticaret.User.Service.UserSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserSercive userSercive;

    @RequestMapping("/kayit")
    public UserResponseDto userKayit(@RequestBody UserRequestDto userRequestDto) {
       return userSercive.userKayit(userRequestDto);



    }


}
