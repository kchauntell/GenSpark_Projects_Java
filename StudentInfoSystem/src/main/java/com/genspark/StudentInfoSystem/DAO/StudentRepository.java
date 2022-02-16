package com.genspark.StudentInfoSystem.DAO;

import com.genspark.StudentInfoSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
