package com.example.amigoscode.service;

import com.example.amigoscode.entity.Student;
import com.example.amigoscode.repository.StudentRepo;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  //  private final StudentRepo studentRepo ;
  @Autowired StudentRepo studentRepo;

  public List<Student> getStudents() {
    List<Student> students = studentRepo.findAll();

    return students;
  }
}
