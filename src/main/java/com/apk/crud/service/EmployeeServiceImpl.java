package com.apk.crud.service;

import com.apk.crud.entity.Employee;
import com.apk.crud.mapper.EmployeeMapper;
import com.apk.crud.model.EmployeeDTO;
import com.apk.crud.repository.EmployeeRepository;
import com.apk.crud.service.interfaces.EmployeeService;
import com.apk.crud.validator.EmployeeValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeValidator employeeValidator;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, EmployeeValidator employeeValidator) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.employeeValidator = employeeValidator;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.convertToEntity(employeeDTO);
        employeeValidator.validateEmployee(employeeDTO);
        employee = employeeRepository.save(employee);
        return employeeMapper.convertToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(employee -> employeeMapper.convertToDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeMapper.convertToDTO(employee.get());
        }
        return null;
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employee) {
        Optional<Employee> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
                originalEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
                originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            }
            Employee employee2 = employeeRepository.save(originalEmployee);
            return employeeMapper.convertToDTO(employee2);
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
