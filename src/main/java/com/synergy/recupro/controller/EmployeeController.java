package com.synergy.recupro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.model.Employee;
import com.synergy.recupro.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    

    @Autowired
    private EmployeeRepository employeeRepository;
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
// Commented these line to test the Spring data rest Create employee instead of legacy call.
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
    @PostMapping("/employees")
    public Employee createAccount(@Valid @RequestBody Employee employees) {
        return employeeRepository.save(employees);
    }
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITMENT_LEAD','BDM','TEAM','ACCOUNT_MANAGER','USER')")
    @PostMapping("/employees/{employeeId}")
    public Employee updateAccount(@PathVariable Long employeeId,
                                   @Valid @RequestBody Employee employeesRequest) {
        return employeeRepository.findById(employeeId)
                .map(employees -> {
                	//employees.setName(employeesRequest.getName());
                	//employees.setDescription(employeesRequest.getDescription());
                    return employeeRepository.save(employees);
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + employeeId, null, employeesRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employees -> {
                	employeeRepository.delete(employees);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + employeeId, null, employeeId));
    }
}
