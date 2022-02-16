package com.genspark.StudentInfoSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="STUDENTS")
public class Student {
  @Id
  @Column(name="studentId")
  @GeneratedValue
  private int id;

  @Column(name="firstName")
  private String firstName;

  @Column(name="lastName")
  private String lastName;

  @Column(name="university")
  private String university;

  @Column(name="mobileNUmber")
  private String mobileNumber;

  @Column(name="email")
  private String email;

  public Student(){};

  public Student(int id, String firstName, String lastName, String university, String mobileNumber, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.university = university;
    this.mobileNumber = mobileNumber;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", university='" + university + '\'' +
        ", mobileNumber='" + mobileNumber + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}


