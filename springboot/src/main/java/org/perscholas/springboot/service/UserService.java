package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.perscholas.springboot.database.dao.UserDAO;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
  public class UserService {

    @Autowired
    private UserDAO userDAO;


    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User createNewUser(RegisterUserFormBean form){
        User user= new User();


        user.setEmail(form.getEmail().toLowerCase());

        //user.setPassword(form.getPassword()); not encoded password
        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        user.setPassword(encoded);

        return userDAO.save(user);

    }

}