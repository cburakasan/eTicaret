package com.asan.eticaret.User.Controller;


import com.asan.eticaret.User.Dto.UserRequestDto;
import com.asan.eticaret.User.Dto.UserResponseDto;
import com.asan.eticaret.User.Service.UserSercive;
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
    @RequestMapping("/giris")
    public UserResponseDto userGiris(@RequestBody UserRequestDto userRequestDto){
        return userSercive.userGiris(userRequestDto);
    }



}
