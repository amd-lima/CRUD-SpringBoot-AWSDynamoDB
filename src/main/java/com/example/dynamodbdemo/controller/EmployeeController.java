package com.example.dynamodbdemo.controller;

import com.example.dynamodbdemo.entity.Employee;
import com.example.dynamodbdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId){
        return employeeRepository.getEmployeeByID(employeeId);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId){
        return employeeRepository.delete(employeeId);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") String employeeId,@RequestBody Employee employee){
        return employeeRepository.update(employeeId, employee);
    }
}
