package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;


    public void createEmployee(CreateEmployeeFormBean form) {


        log.debug("id" + form.getId());
        log.info("firstname:" + form.getFirstName());
        log.info("lastname:" + form.getLastName());
        log.info("department:" + form.getDepartment());



        Employee employee = employeeDAO.findById(form.getId());



        if ( employee == null) {
            employee = new Employee();
        }

        employee.setFirstname(form.getFirstName());
        employee.setLastname(form.getLastName());
        employee.setDepartment(form.getDepartment());


        employeeDAO.save(employee);
    }

}
