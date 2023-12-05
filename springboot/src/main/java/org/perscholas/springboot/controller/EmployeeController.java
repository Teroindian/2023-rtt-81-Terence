package org.perscholas.springboot.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.perscholas.springboot.service.CustomerService;
import org.perscholas.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;


    @Autowired
    private EmployeeService employeeService;







    @GetMapping("/employee/edit/{employeeId}")
    public ModelAndView editEmployee(@PathVariable int employeeId){

        ModelAndView response = new ModelAndView("employee/create");

        Employee employee  = employeeDAO.findById(employeeId);

        CreateEmployeeFormBean form = new CreateEmployeeFormBean();
        if ( employee != null ) {
            form.setId(employee.getId());
            form.setFirstName(employee.getFirstname());
            form.setLastName(employee.getLastname());
            form.setDepartment(employee.getDepartment());
        } else {
            log.warn(" employee with id " + employeeId + " was not found");
        }
        response.addObject("form", form);

        return response;
    }

    @GetMapping("/employee/search")
    public ModelAndView searchEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        ModelAndView response = new ModelAndView("employee/search");

        // Log the values received from the form
        log.debug("In the employee search controller method: firstname = " + firstName + ", lastName = " + lastName);

        if (firstName != null || lastName != null) {
            // Use both first name and last name parameters in the search
            List<Employee> employees = employeeDAO.findByFirstNameOrLastName(firstName, lastName);
            log.debug("Number of employees found: " + employees.size());
            response.addObject("employeeVar", employees);
            response.addObject("search", firstName); // Assuming you want to use the first name for display
            for (Employee employee : employees) {
                log.debug("Employee: id = " + employee.getId() + ", last name = " + employee.getLastname());
            }
        }

        return response;
    }




    @GetMapping("/employee/create")
    public ModelAndView createEmployee(
    ){
        ModelAndView response = new ModelAndView("employee/create");

        log.info(" In create employee with no Args");
        return response;
    }


    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult){
        ModelAndView response = new ModelAndView("employee/create");


       /* if (bindingResult.hasErrors()) {
            log.info("######################### In create employee submit - has errors #########################");
            ModelAndView response = new ModelAndView("employee/create");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }*/


        employeeService.createEmployee(form);

        log.info(" In create employee with  Args");


      /*  log.info("######################### In create employee submit #########################");

        Employee e = employeeService.createEmployee(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/employee/edit/" + e.getId() + "?success=Employee Saved Successfully");*/
        return response;
    }


}
