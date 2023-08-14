package com.apk.crud.service.interfaces;

import com.apk.crud.entity.Employee;
import com.apk.crud.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(EmployeeDTO employeeDTO);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    String deleteDepartmentById(Long id);
}
