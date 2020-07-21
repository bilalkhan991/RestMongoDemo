package com.example.RestDemo.services;

import com.example.RestDemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    List<Employee> getEmployees();

    Employee updateEmployee(Employee employee, String id);

    void deleteEmployee(String id);
}
