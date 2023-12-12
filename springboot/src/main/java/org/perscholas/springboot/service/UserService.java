package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.perscholas.springboot.database.dao.UserDAO;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
  public class UserService {

    @Autowired
    private UserDAO userDAO;


    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;



    // 1) Alter the user table add a column called create_date of time timestamp
    // 2) update the user entity and add teh create_date field
    // 3) Google how to use a @Temporal to define the create_date field as a timestamp
    // 4) In the createNewUser function set the create_date field to the current date and time before saving to the database


    public User createNewUser(RegisterUserFormBean form){
        User user= new User();


        user.setEmail(form.getEmail().toLowerCase());

        //user.setPassword(form.getPassword()); not encoded password
        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        user.setPassword(encoded);



        // Set the create_date field to the current date and time
        user.setCreateDate(new Date());

        return userDAO.save(user);

    }

}
// 1) on the customer search results I want you to add another column that says Detail
// 2) This will be an <a href> tag that has the word Detail as the text very similar to how edit works
// 3) Create a new controller method for customer detail.  This controller method will take a request parm that is the customer id
// 4) in the customer DAO createa  findByid method that returns a single customer and uses the request param to find the customer
// 4) Create a new jsp file for customer detail that displays the customer id, first name, last name, phone, city, and image url
//    none of these fields are editable.
// 5) on the customer detail page creaet a button that says "Edit" and when you click it it will take you to the edit page for that customer