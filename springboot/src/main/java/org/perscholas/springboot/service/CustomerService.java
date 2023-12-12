package org.perscholas.springboot.service;


import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.controller.CustomerController;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    public Customer createCustomer(CreateCustomerFormBean form) {
        log.debug("id" + form.getId());
        log.info("firstname:" + form.getFirstName());
        log.info("lastname:" + form.getLastName());
        log.info("phone:" + form.getPhone());
        log.info("city:" + form.getCity());


        Customer customer = customerDAO.findById(form.getId());


        if ( customer == null) {
             customer = new Customer();

//line of code loads current user logged in user record from database
            User user = authenticatedUserService.loadCurrentUser();

//then we set our user id onto customer record we are about to create
            customer.setUserId(user.getId());
        }

        customer.setFirstname(form.getFirstName());
        customer.setLastname(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());
        customer.setImageUrl(form.getImageUrl());

       return customerDAO.save(customer);
    }



   public Customer getCustomerById(int customerId) {
        return customerDAO.findById(customerId);
    }


    public Customer findById(int customerId) {
        return customerDAO.findById(customerId);
    }
}
