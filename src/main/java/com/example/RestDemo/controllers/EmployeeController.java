package com.example.RestDemo.controllers;

import com.example.RestDemo.model.Employee;
import com.example.RestDemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee(){
        return  new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable("id") String id){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") String id){

        employeeService.deleteEmployee(id);
    }

}
