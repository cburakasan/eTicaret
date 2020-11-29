package com.itelligence.eticaret.User.Service;


import com.itelligence.eticaret.User.Dto.UserRequestDto;
import com.itelligence.eticaret.User.Model.User;
import com.itelligence.eticaret.User.Repository.UserRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.JUnitTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import  org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserSerciveTest {
@Autowired
    UserRepository userRepository;

@Test
@Rollback(value = false)
    public void testUserSave(){
    User user = new User();
    user.setPassword("asda");
    user.setUsername("nesrin");
   User saveUser = userRepository.save(user);
    assertNotNull(saveUser);
}
@Test
@Rollback(value = false)
    public void testUserFindByUsername(){
    String username = "nesrin";
    User byUsername = userRepository.findByUsername(username);
    assertEquals(byUsername.getUsername(),username);

}




}