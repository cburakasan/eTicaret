package com.itelligence.eticaret.User.UserService;

import com.itelligence.eticaret.User.Dto.UserRequestDto;
import com.itelligence.eticaret.User.Dto.UserResponseDto;
import com.itelligence.eticaret.User.Model.User;
import com.itelligence.eticaret.User.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponseDto userKayit(UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = new UserResponseDto();
        String username = null;
        String password = null;
        String email = null;
        Integer gsm = null;
        try {
            username = userRequestDto.getUsername();
            password = userRequestDto.getPassword();
            email = userRequestDto.getEmail();
            gsm = userRequestDto.getGsm();
            User user = userRepository.findByUsername(username);
            if (user != null) {
                throw new RuntimeException("Bu kullanıcı adı daha önce alınmıştır.");
            } else if (email != null || gsm != null) {
                throw new RuntimeException("Girilen telefon no veya email adresi ile daha önce kayit olusturulmustur.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            userResponseDto.setMessage(e.getMessage());
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGsm(gsm);
        userRepository.save(user);
        return userResponseDto;


    }

//    public static void main(String[] args) {
//         test();
//    }
//
//    public static void  test(){
//        SessionFactory sessionFactory = new Configuration ().configure ().buildSessionFactory ();
//        Session session = sessionFactory.openSession ();
//        Transaction transaction = session.beginTransaction ();
//        User user = new User ();
//        user.setUsername ("doruk");
//        session.save (user);
//        transaction.commit ();
//        session.close ();
//
//
//
//    }

}
