package com.genspark.EmployeeManagementSystem.Controller;


import com.genspark.EmployeeManagementSystem.Entity.Employee;
import com.genspark.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

  @Autowired
  public EmployeeService employeeService;

  @GetMapping("/")
  public String home(){
    return """
            <html>
              <body>
                <h1>Employee Database</h1>
                  <h3> Access, Add, Update information for all Active and Inactive Employee Public Records </h3>
                  <p>
                    Please reference all employee records with caution. These are public records, so no sensitive information
                    is recorded through this database. Enjoy the system!
                  </p>
              </body>
            </html>
            """;
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees(){
    return this.employeeService.getAllEmployees();
  }

  @GetMapping("/employees/{employeeId}")
  public Optional<Employee> getEmployee(@PathVariable int employeeId) {
    return this.employeeService.getEmployee(employeeId);
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    return this.employeeService.addEmployee(employee);
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    return this.employeeService.updateEmployee(employee);
  }

  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {
    this.employeeService.deleteEmployee(employeeId);
    return "Employee Successfully Removed";
  }
}
