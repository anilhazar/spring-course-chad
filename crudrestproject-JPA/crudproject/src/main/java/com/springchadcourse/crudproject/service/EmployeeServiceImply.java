package com.springchadcourse.crudproject.service;

import com.springchadcourse.crudproject.dao.EmployeeRepository;
import com.springchadcourse.crudproject.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImply implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImply(EmployeeRepository employeeDAO){
        this.employeeRepository = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        if (result.isEmpty()){
            throw new  RuntimeException("Could not find the employee id => " + id);
        }
        return result.get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save( employee );
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById( id );
    }
}
