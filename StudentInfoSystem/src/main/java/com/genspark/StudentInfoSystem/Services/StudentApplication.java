package com.genspark.StudentInfoSystem.Services;

import com.genspark.StudentInfoSystem.Entity.Student;

import java.util.List;
import java.util.Optional;

//this mimics what the repository would be
public interface StudentApplication {

  public List<Student> getAllStudents();
  public Optional<Student> getStudent(int studentId);
  public Student addStudent(Student student) throws Exception;
  public Student updateStudent(Student student);
  public String deleteStudent(int studentId);

}
