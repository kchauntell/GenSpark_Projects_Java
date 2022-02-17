package com.genspark.EmployeeManagementSystem.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

  public Employee(){}

  public Employee(int id, String firstName, String lastName, String email, String department, String mobileNumber, String university) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.department = department;
    this.mobileNumber = mobileNumber;
    this.university = university;
  }

  @Id
  @Column(name="employeeId")
  @GeneratedValue
  private int id;

  @Column(name = "first_name")
  private String firstName;


  @Column(name = "last_name")
  private String lastName;


  @Column(name = "email")
  private String email;

  @Column(name = "department")
  private String department;


  @Column(name = "mobile_number")
  private String mobileNumber;

  @Column(name = "university")
  private String university;

  public long getEmployeeId() {
    return id;
  }

  public void setEmployeeId(int employeeId) {
    this.id = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "employeeId=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", Email='" + email + '\'' +
        ", department='" + department + '\'' +
        ", mobileNumber='" + mobileNumber + '\'' +
        ", branch='" + university + '\'' +
        '}';
  }
}
