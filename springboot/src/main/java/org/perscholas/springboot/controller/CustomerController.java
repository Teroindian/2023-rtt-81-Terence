package org.perscholas.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {
// create an employee table with the following columns: id, first_name, last_name, department_name
    // create an entity and a dao for the employee table
    // create a controller for the employee table
    // create a form bean for the employee table
    // create an html page with the form on it

    @Autowired
    private CustomerDAO customerDAO;

   /* @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam (required = false) String search){
        ModelAndView response = new ModelAndView("customer/search");

       log.debug(" In the customer search controller method : search parameter = " + search);

       if (search !=null ) {
            List<Customer> customers = customerDAO.findByFirstName(search);
           response.addObject("customerVar",customers);
           response.addObject("search",search);
            for ( Customer customer : customers) {
                log.debug(" customer: id =" + customer.getId() + " last name =" + customer.getLastname());
            }


        }


        return response;
    }*/

    @GetMapping("/customer/search")
    public ModelAndView search(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        ModelAndView response = new ModelAndView("customer/search");

        // Log the values received from the form
        log.debug("In the customer search controller method: firstName = " + firstName + ", lastName = " + lastName);

        if (firstName != null || lastName != null) {
            // Use both first name and last name parameters in the search
            List<Customer> customers = customerDAO.findByFirstNameOrLastName(firstName, lastName);
            response.addObject("customerVar", customers);
            response.addObject("search", firstName); // Assuming you want to use the first name for display
            for (Customer customer : customers) {
                log.debug("Customer: id = " + customer.getId() + ", last name = " + customer.getLastname());
            }
        }

        return response;
    }


    @GetMapping("/customer/create")
    public ModelAndView createCustomer(
    ){
        ModelAndView response = new ModelAndView("customer/create");

        log.debug(" In create customer with no Args");
        return response;
    }

    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomer( CreateCustomerFormBean form
    ){
        ModelAndView response = new ModelAndView("customer/create");

        log.info("firstname:" + form.getFirstName());
        log.info("lastname:" + form.getLastName());
        log.info("phone:" + form.getPhone());
        log.info("city:" + form.getCity());

        Customer customer =new Customer();
        customer.setFirstname(form.getFirstName());
        customer.setLastname(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());

        customerDAO.save(customer);


        log.info(" In create customer with  Args");
        return response;
    }

}
