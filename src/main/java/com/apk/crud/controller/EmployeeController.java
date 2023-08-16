package com.apk.crud.controller;

import com.apk.crud.model.APIResponse;
import com.apk.crud.model.EmployeeDTO;
import com.apk.crud.service.interfaces.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employee")
    public ResponseEntity<APIResponse<EmployeeDTO>> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(APIResponse.success(employeeService.saveEmployee(employeeDTO)));
    }

    @GetMapping("/employee")
    public ResponseEntity<APIResponse<List<EmployeeDTO>>> getAllEmployees() {
        return ResponseEntity.ok(APIResponse.success(employeeService.fetchAllEmployees()));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<APIResponse<EmployeeDTO>> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(APIResponse.success(employeeService.getEmployeeById(id)));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<APIResponse<EmployeeDTO>> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(APIResponse.success(employeeService.updateEmployeeById(id, employee)));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<APIResponse<String>> deleteEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(APIResponse.success(employeeService.deleteDepartmentById(id)));
    }
}
