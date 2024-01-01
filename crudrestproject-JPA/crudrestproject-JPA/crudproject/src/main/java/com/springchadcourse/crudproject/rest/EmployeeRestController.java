package com.springchadcourse.crudproject.rest;

import com.springchadcourse.crudproject.entity.Employee;
import com.springchadcourse.crudproject.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee =  employeeService.findById( id );
        if (employee == null){
            throw new RuntimeException("Employee does not exist, id: " + id);
        }
        return  employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployeeById(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteById( id );
        return "Employee with id: "+ id + " deleted";

    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.save( employee );

    }


}
