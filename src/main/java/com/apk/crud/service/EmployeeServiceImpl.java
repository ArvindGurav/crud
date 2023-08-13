package com.apk.crud.service;

import com.apk.crud.entity.Employee;
import com.apk.crud.repository.EmployeeRepository;
import com.apk.crud.service.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
                originalEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
                originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            }
            return employeeRepository.save(originalEmployee);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }
}
