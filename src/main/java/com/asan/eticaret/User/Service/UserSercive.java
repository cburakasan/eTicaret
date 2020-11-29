package com.asan.eticaret.User.Service;

import com.asan.eticaret.Urun.Exception.UserException;
import com.asan.eticaret.User.Dto.UserRequestDto;
import com.asan.eticaret.User.Dto.UserResponseDto;
import com.asan.eticaret.User.Model.User;
import com.asan.eticaret.User.Repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class UserSercive {
    @Autowired
    UserRepository userRepository;

    public UserResponseDto userKayit(UserRequestDto userRequestDto) {
        log.info("User kayit servisine girildi");
        UserResponseDto userResponseDto = new UserResponseDto();
        String username = userRequestDto.getUsername();
        String gsm = userRequestDto.getGsm();
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();
        try {
            if (username != null && email != null && gsm != null && password != null) {
                User byUsernameOrGsmOrEmail = userRepository.findByUsernameOrGsmOrEmail(username, gsm, email);
                if (byUsernameOrGsmOrEmail != null){
                    throw new UserException("Girilen verilere ait kullanici bilgisi mevcuttur.", new Exception());
                }
                User user = new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setGsm(gsm);
                user.setPassword(password);
                user=userRepository.save(user);
                Long id = user.getId();
                userResponseDto.setId(id);


            } else {
                throw new UserException("username, email, gsm ve password alanları dolu olmalidir.", new Exception());
            }
        } catch (UserException e) {
            String message = e.getMessage();
            userResponseDto.setHataMessage(message);
            log.error(message,e);


        } catch (Exception e) {
            String message = "Kullanici kayit isleminde bir hata olustu";
            userResponseDto.setHataMessage(message);
            log.error(message,e);

        }

        return userResponseDto;
    }

    public UserResponseDto userGiris(UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = new UserResponseDto();
        try {
            String email = userRequestDto.getEmail();
            String password = userRequestDto.getPassword();
            User user = userRepository.findByEmailAndPassword(email, password);
            if (user == null) {
                throw new UserException("email veya password hatali", new Exception());
            }
            userResponseDto.setId(user.getId());
            userResponseDto.setUsername(user.getUsername());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setGsm(user.getGsm());
        }catch (Exception exception){
            String hataMesaji="email veya password hatali";
            userResponseDto.setHataMessage(hataMesaji);
            log.error(hataMesaji);
            return userResponseDto;

        }
        log.info("giris basarili");
        return userResponseDto;

    }
}
