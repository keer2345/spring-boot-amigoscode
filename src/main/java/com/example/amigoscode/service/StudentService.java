package com.example.amigoscode.service;

import com.example.amigoscode.entity.Student;
import com.example.amigoscode.repository.StudentRepo;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired StudentRepo studentRepo;

  public List<Student> getStudents() {
    List<Student> students = studentRepo.findAll();

    return students;
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    studentRepo.save(student);
  }

  public void deleteStudent(Long id) {
    boolean exists = studentRepo.existsById(id);
    if (!exists) {
      throw new IllegalStateException("student with id [ " + id + " ] does not exists.");
    }
    studentRepo.deleteById(id);
  }

  @Transactional
  public void updateStudent(Long id, String name, String email) {
    Student student =
        studentRepo
            .findById(id)
            .orElseThrow(
                () -> new IllegalStateException("student with id [ " + id + " ] does not exists!"));
    if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
      student.setName(name);
    }
    if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
      Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
      if (studentOptional.isPresent()) {
        throw new IllegalStateException("email token");
      }
      student.setEmail(email);
    }
  }
}
