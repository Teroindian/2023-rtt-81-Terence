package org.perscholas.springboot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.formbean.RegisterUserFormBean;

import org.perscholas.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
class AuthController {


    @Autowired
    private UserService userService;
    @GetMapping("/auth/register")
    public ModelAndView register() {

        ModelAndView response = new ModelAndView();
        response.setViewName("auth/register");
        return response;
    }


    @GetMapping("/auth/registerSubmit")
    public ModelAndView registerSubmit(@Valid RegisterUserFormBean form, BindingResult bindingResult)
    {


        if (bindingResult.hasErrors()) {
            log.info("######################### In register user submit - has errors #########################");
            ModelAndView response = new ModelAndView("auth/register");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In register user submit #########################");

        User u =   userService.createNewUser(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/");


        return response;
    }


}
