package com.apk.crud.mapper;

import com.apk.crud.entity.Employee;
import com.apk.crud.model.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeSalary(employeeDTO.getEmployeeSalary());
        return employee;
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setEmployeeSalary(employee.getEmployeeSalary());
        return employeeDTO;
    }
}
