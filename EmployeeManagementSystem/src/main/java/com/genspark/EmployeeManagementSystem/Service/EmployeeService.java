package com.genspark.EmployeeManagementSystem.Service;

import com.genspark.EmployeeManagementSystem.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  public List<Employee> getAllEmployees();
  public Optional<Employee> getEmployee(int employeeId);
  public Employee addEmployee(Employee employee);
  public Employee updateEmployee(Employee employee);
  public String deleteEmployee(int employeeId);
}
