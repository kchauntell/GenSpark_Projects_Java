package com.genspark.EmployeeManagementSystem.Service;


import com.genspark.EmployeeManagementSystem.DAO.EmployeeRepository;
import com.genspark.EmployeeManagementSystem.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  @Autowired
  public EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}


  @Override
  public List<Employee> getAllEmployees() {
    return this.employeeRepository.findAll();
  }

  @Override
  public Optional<Employee> getEmployee(int studentId) {
    return this.employeeRepository.findById(studentId);
  }

  @Override
  public Employee addEmployee(Employee employee) {
    return this.employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    Optional<Employee> employeeOptional = this.employeeRepository.findById((int) employee.getEmployeeId());
    if(employeeOptional.isEmpty()) {return null;}

    Employee employeeToUpdate = employeeOptional.get();

    if(employee.getFirstName() != null) {employeeToUpdate.setFirstName(employee.getFirstName());}
    if(employee.getLastName() != null) {employeeToUpdate.setLastName(employee.getLastName());}
    if(employee.getEmail() != null) {employeeToUpdate.setEmail(employee.getEmail());}
    if(employee.getMobileNumber() != null) {employeeToUpdate.setMobileNumber(employee.getMobileNumber());}
    if(employee.getUniversity() != null) {employeeToUpdate.setUniversity(employee.getUniversity());}
    if(employee.getDepartment() != null){employeeToUpdate.setDepartment(employee.getDepartment());}

    Employee updatedEmployee = this.employeeRepository.save(employeeToUpdate);
    return updatedEmployee;

  }

  @Override
  public String deleteEmployee(int employeeId) {
    Optional<Employee> employeeOptional = this.employeeRepository.findById(employeeId);
    if(employeeOptional.isEmpty()) {return null;}

    Employee employeeToDelete = employeeOptional.get();
    this.employeeRepository.delete(employeeToDelete);
    return "Successfully Deleted Employee";
  }
}
