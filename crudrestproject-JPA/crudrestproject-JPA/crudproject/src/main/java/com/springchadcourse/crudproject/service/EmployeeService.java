package com.springchadcourse.crudproject.service;

import com.springchadcourse.crudproject.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int Id);

    Employee save(Employee employee);

    void deleteById(int id);
}
