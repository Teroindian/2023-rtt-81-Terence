package org.perscholas.springboot.controller;


import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

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

    @GetMapping("/customer/edit/{customerId}")
  //  public ModelAndView editCustomer(@PathVariable int customerId){
    public ModelAndView editCustomer(@PathVariable int customerId, @RequestParam(required = false) String success) {
        log.info("######################### In /customer/edit #########################");

        ModelAndView response = new ModelAndView("customer/create");

        Customer customer  = customerDAO.findById(customerId);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }

        CreateCustomerFormBean form = new CreateCustomerFormBean();
        if ( customer != null ) {
            form.setId(customer.getId());
            form.setFirstName(customer.getFirstname());
            form.setLastName(customer.getLastname());
            form.setPhone(customer.getPhone());
            form.setCity(customer.getCity());
            form.setImageUrl(customer.getImageUrl());
        } else {
            log.warn(" customer with id " + customerId + " was not found");
        }
        response.addObject("form", form);

        return response;
    }

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
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult)
    {


        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit - has errors #########################");
            ModelAndView response = new ModelAndView("customer/create");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In create customer submit #########################");

        Customer c = customerService.createCustomer(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/customer/edit/" + c.getId() + "?success=Customer Saved Successfully");


        return response;
    }




    @GetMapping("/customers/myCustomers")
    public void myCustomers() {

        ModelAndView response = new ModelAndView("customer/create");
        log.info("##################### IN MY Customers  #############");



        // 1) Use the authenticated user service to find the logged in user
        User user = authenticatedUserService.loadCurrentUser();


        // 2) Create a DAO method that will find by userId
             //written on customer DAO
        // 3) use the authenticated user id to find a list of all customers created by this user
        List<Customer> customers = customerDAO.findByUserId(user.getId());

        // 4) loop over the customers created and log.debug the customer id and customer last name

        for (Customer customer : customers) {
            log.debug("Customer ID: " + customer.getId() + ", Last Name: " + customer.getLastname());
        }

//The overall purpose of this method is to fetch all customers associated with the currently authenticated user and log their IDs and last names.
// This could be useful in a system where users have associated customers and you want to view or debug information about these customers.

    }




    @GetMapping("/customer/detail/{customerId}")
    public ModelAndView showCustomerDetail(@PathVariable int customerId) {
        log.info("######################### In /customer/detail #########################");

        ModelAndView response = new ModelAndView("customer/customer-detail");

        Customer customer = customerDAO.findById(customerId);

        if (customer != null) {
            response.addObject("customerVar", List.of(customer)); // Wrap single customer in a list for consistency
            // Add additional attributes if needed
        } else {
            log.warn("Customer with id " + customerId + " was not found");
            // You might want to redirect to an error page here
        }

        return response;
    }



   /* @GetMapping("/customer/edit/{customerId}")
    public ModelAndView editCustomer(@PathVariable int customerId) {
        ModelAndView response = new ModelAndView("customer/edit");

        Customer customer = customerService.findById(customerId);

        if (customer != null) {
            response.addObject("customer", customer);
        } else {
            log.warn("Customer with id " + customerId + " was not found");
            // You might want to redirect to an error page here
        }

        return response;
    }*/



 /*   @GetMapping("/customer/edit-form/{customerId}")
    public ModelAndView editCustomer(@PathVariable int customerId) {
        ModelAndView response = new ModelAndView("customer/create");

        Customer customer = customerService.findById(customerId);

        if (customer != null) {
            response.addObject("customer", customer);
        } else {
            log.warn("Customer with id " + customerId + " was not found");
            // You might want to redirect to an error page here
        }

        return response;
    }*/

    @GetMapping("/customer/fileupload")
    public ModelAndView fileUpload(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("customer/fileupload");


        Customer customer = customerDAO.findById(id);
        response.addObject("customer",customer);



        log.info(" In fileupload with no Args");
        return response;
    }



    @PostMapping("/customer/fileUploadSubmit")
    public ModelAndView fileUploadSubmit(@RequestParam("file") MultipartFile file,@RequestParam Integer id){
   // public ModelAndView fileUploadSubmit(@RequestParam("file") MultipartFile file, @RequestParam Integer customerId) {
      // ModelAndView response = new ModelAndView("customer/fileupload");
         ModelAndView response = new ModelAndView("redirect:/customer/detail?id=" + id);

        log.info("Filename = " + file.getOriginalFilename());
        log.info("Size     = " + file.getSize());
        log.info("Type     = " + file.getContentType());


        // Get the file and save it somewhere
        File f = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(f.getAbsolutePath())) {
            IOUtils.copy(file.getInputStream(), outputStream);
        } catch (Exception e) {


            e.printStackTrace();
        }


        // these 3 lines will load customer id passed in
        // update the image url field and then save the customer to the database
        Customer customer = customerDAO.findById(id);
        customer.setImageUrl("/pub/images/" +  file.getOriginalFilename());
        customerDAO.save(customer);

        return response;

   /* @PostMapping("/customer/fileUploadSubmit")
    public ModelAndView fileUploadSubmit(@RequestParam("file") MultipartFile file,
                                         @RequestParam Integer id) {
        ModelAndView response = new ModelAndView("redirect:/customer/detail?id=" + id);

        log.info("Filename = " + file.getOriginalFilename());
        log.info("Size     = " + file.getSize());
        log.info("Type     = " + file.getContentType());


        // Get the file and save it somewhere
        File f = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(f.getAbsolutePath())) {
            IOUtils.copy(file.getInputStream(), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // these 3 lines of code will load the customer by the id passed in
        // update the image url field and then save the customer to the database
        Customer customer = customerDAO.findById(id);
        customer.setImageUrl("/pub/images/" + file.getOriginalFilename());
        customerDAO.save(customer);

        return response;
    }*/

    }











}
