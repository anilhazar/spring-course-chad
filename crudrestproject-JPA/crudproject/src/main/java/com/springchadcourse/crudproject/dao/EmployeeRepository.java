package com.springchadcourse.crudproject.dao;

import com.springchadcourse.crudproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
