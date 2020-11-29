package com.itelligence.eticaret.User.Repository;


import com.itelligence.eticaret.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameOrGsmOrEmail(String username, String gsm, String email);
    User findByUsername(String username);
    User findByEmailAndPassword(String email,String password);



}
