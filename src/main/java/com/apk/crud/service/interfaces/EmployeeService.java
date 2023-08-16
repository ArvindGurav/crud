package com.apk.crud.service.interfaces;

import com.apk.crud.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> fetchAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employee);

    String deleteDepartmentById(Long id);
}
