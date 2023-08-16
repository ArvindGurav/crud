package com.apk.crud.validator;

import com.apk.crud.exceptions.EmployeeValidationException;
import com.apk.crud.constants.ErrorCode;
import com.apk.crud.model.APIErrors;
import com.apk.crud.model.EmployeeDTO;
import com.apk.crud.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.apk.crud.constants.ErrorMessages.EMPLOYEE_NAME_BLANK;
import static com.apk.crud.constants.ErrorMessages.EMPLOYEE_SALARY_ZERO;

@Component
public class EmployeeValidator {


    public void validateEmployee(EmployeeDTO employeeDTO) {
        List<APIErrors> errorsList = new ArrayList<>();

        if(StringUtils.isBlank(employeeDTO.getEmployeeName())) {
            errorsList.add(new APIErrors(EmployeeDTO.class.getSimpleName(), "EmployeeName",
                    employeeDTO.getEmployeeName(), EMPLOYEE_NAME_BLANK));
        }
        if(employeeDTO.getEmployeeSalary() <= 0) {
            errorsList.add(new APIErrors(EmployeeDTO.class.getSimpleName(), "EmployeeSalary",
                    Float.toString(employeeDTO.getEmployeeSalary()), EMPLOYEE_SALARY_ZERO));
        }

        if(!errorsList.isEmpty()) {
            throw new EmployeeValidationException(ErrorCode.ERROR_VALIDATING_EMPLOYEE, errorsList);
        }
    }
}
