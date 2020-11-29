package com.asan.eticaret.User.Service;


import com.asan.eticaret.User.Model.User;
import com.asan.eticaret.User.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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