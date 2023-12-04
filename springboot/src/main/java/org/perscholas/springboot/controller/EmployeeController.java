package org.perscholas.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;





    @GetMapping("/employee/search")
    public ModelAndView searchEmployees(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastName
    ) {
        ModelAndView response = new ModelAndView("employee/search");

        // Log the values received from the form
        log.debug("In the employee search controller method: firstname = " + firstname + ", lastName = " + lastName);

        if (firstname != null || lastName != null) {
            // Use both first name and last name parameters in the search
            List<Employee> employees = employeeDAO.findByFirstNameOrLastName(firstname, lastName);
            log.debug("Number of employees found: " + employees.size());
            response.addObject("employeeVar", employees);
            response.addObject("search", firstname); // Assuming you want to use the first name for display
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
    public ModelAndView createEmployee( CreateEmployeeFormBean form
    ){
        ModelAndView response = new ModelAndView("employee/create");

       log.info("firstname:" + form.getFirstName());
       log.info("lastname:" + form.getLastName());
       log.info("department:" + form.getDepartment());


        Employee employee = new Employee();

        employee.setFirstname(form.getFirstName());
        employee.setLastname(form.getLastName());
        employee.setDepartment(form.getDepartment());


      //  customerDAO.save(customer);
          employeeDAO.save(employee);

        log.info(" In create employee with  Args");
        return response;
    }




}