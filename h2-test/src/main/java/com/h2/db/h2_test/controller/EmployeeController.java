package com.h2.db.h2_test.controller;

import com.h2.db.h2_test.entity.Employee;
import com.h2.db.h2_test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee>  getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity ::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id ,@RequestBody Employee employee){
        try {
            Employee employee1 = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(employee1);
        }catch(RuntimeException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
