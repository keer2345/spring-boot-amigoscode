package com.example.amigoscode.service;

import static java.time.Month.JANUARY;

import com.example.amigoscode.entity.Student;
import com.example.amigoscode.repository.StudentRepo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepo studentRepo) {
    return args -> {
      Student aaa = new Student("aaa", "aaa@a.com", LocalDate.of(2000, JANUARY, 31), 21);
      Student bbb = new Student("bbb", "bbb@a.com", LocalDate.of(2001, JANUARY, 31), 22);
      Student ccc = new Student("ccd", "aaa@a.com", LocalDate.of(2002, JANUARY, 31), 23);
      studentRepo.saveAll(List.of(aaa, bbb, ccc));
    };
  }
}
