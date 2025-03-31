package com.h2.db.h2_test.service;

import com.h2.db.h2_test.entity.Employee;
import com.h2.db.h2_test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id , Employee employee){
        Employee employee1 = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        employee1.setName(employee.getName());
        employee1.setCity(employee.getCity());
        employee1.setEmail(employee.getEmail());

        return employeeRepository.save(employee1);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }


}
