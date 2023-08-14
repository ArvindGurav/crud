package com.apk.crud.model;

import com.apk.crud.entity.Employee;
import lombok.Data;

@Data
public class EmployeeDTO {
    private Long employeeId;

    private String employeeName;

    private float employeeSalary;

    public Employee convertToEntity() {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeSalary(employeeSalary);
        return employee;
    }
}
