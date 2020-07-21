package com.example.RestDemo.services;

import com.example.RestDemo.model.Employee;
import com.example.RestDemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, String id) {
        //Learn about Optional.
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        Employee originalEmployee = foundEmployee.get();
        originalEmployee.setFirstName(employee.getFirstName());
        return employeeRepository.save(originalEmployee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

}
