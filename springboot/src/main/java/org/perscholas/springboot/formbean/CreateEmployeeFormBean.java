package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateEmployeeFormBean {

    private Integer Id;

    @NotEmpty(message = " First Name is required")
    @Length( max = 45 ,message = "First Name must be less than 45 characters.")
    private String firstName;

    @NotEmpty(message = " Last Name is required")
    @Length( max = 45 ,message = "Length must be less than 45 characters.")
    private String lastName;

    @NotEmpty(message = " Department is required")
    @Length( max = 45 ,message = "Length must be less than 45 characters.")
    private String department;
}





