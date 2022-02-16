package com.genspark.StudentInfoSystem.Controller;


import com.genspark.StudentInfoSystem.Entity.Student;
import com.genspark.StudentInfoSystem.Services.StudentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

  @Autowired
  private StudentApplication studentApplication;



  @GetMapping("/students")
  public List<Student> getStudents(){
    return this.studentApplication.getAllStudents();
  }

  @GetMapping("/students/{studentId}")
  public Optional<Student> getStudent(@PathVariable int studentId ){
    return this.studentApplication.getStudent(studentId);
  }

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student student) throws Exception {
    return this.studentApplication.addStudent(student);
  }

  @PutMapping("/students")
  public Student updateStudent(@RequestBody Student student) {
    return this.studentApplication.updateStudent(student);
  }

  @DeleteMapping("/students/{studentId}")
  public String deleteStudent(@PathVariable int studentId){

    this.studentApplication.deleteStudent(studentId);
    return "Successfully deleted!";
  }
}
