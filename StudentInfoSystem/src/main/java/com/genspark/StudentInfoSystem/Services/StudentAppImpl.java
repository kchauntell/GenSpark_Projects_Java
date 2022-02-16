package com.genspark.StudentInfoSystem.Services;

import com.genspark.StudentInfoSystem.DAO.StudentRepository;
import com.genspark.StudentInfoSystem.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAppImpl implements StudentApplication{
  @Autowired
  public StudentRepository studentRepository;

  public StudentAppImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> getAllStudents() {
    return this.studentRepository.findAll();
  }

  @Override
  public Optional<Student> getStudent(int studentId) {
    return this.studentRepository.findById(studentId);
  }

  @Override
  public Student addStudent(Student student) {
    return this.studentRepository.save(student);
  }

  @Override
  public Student updateStudent(Student student) {
    Optional<Student> studentToUpdateOptional = this.studentRepository.findById(student.getId());
    if(!studentToUpdateOptional.isPresent()) {
      return null;
    }

    Student studentToUpdate = studentToUpdateOptional.get();

    if(student.getFirstName() != null) {
      studentToUpdate.setFirstName(student.getFirstName());
    }
    if(student.getLastName() != null) {
      studentToUpdate.setLastName(student.getLastName());
    }
    if(student.getUniversity() != null) {
      studentToUpdate.setUniversity(student.getUniversity());
    }
    if(student.getMobileNumber() != null) {
      studentToUpdate.setMobileNumber(student.getMobileNumber());
    }
    if (student.getEmail() != null) {
      studentToUpdate.setEmail(student.getEmail());
    }

    Student updatedStudent = this.studentRepository.save(studentToUpdate);
    return updatedStudent;

  }

  @Override
  public String deleteStudent(int studentId) {
    Optional<Student> studentToDeleteOptional = this.studentRepository.findById(studentId);
    if(!studentToDeleteOptional.isPresent()) {
      return null;
    }

    Student studentToDelete = studentToDeleteOptional.get();
    this.studentRepository.delete(studentToDelete);
    return "Successfully deleted: " + String.valueOf(studentToDelete);
  }
}
