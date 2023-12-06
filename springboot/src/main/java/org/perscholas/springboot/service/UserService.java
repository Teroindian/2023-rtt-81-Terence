package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.UserDAO;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
  public class UserService {

    @Autowired
    private UserDAO userDAO;


    public User createNewUser(RegisterUserFormBean form){
        User user= new User();


        user.setEmail(form.getEmail());

        user.setPassword(form.getPassword());

        return userDAO.save(user);

    }

}
