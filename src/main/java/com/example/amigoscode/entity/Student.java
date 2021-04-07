package com.example.amigoscode.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(
      name = "student_sequence",
      sequenceName = "student_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;
  private String email;
  private LocalDate dayOfMonth;
  private int age;

  public Student(String name, String email, LocalDate dayOfMonth, int age) {
    this.name = name;
    this.email = email;
    this.dayOfMonth = dayOfMonth;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDayOfMonth() {
    return dayOfMonth;
  }

  public void setDayOfMonth(LocalDate dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Student(Long id, String name, String email, LocalDate dayOfMonth, int age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dayOfMonth = dayOfMonth;
    this.age = age;
  }

  public Student() {}

  @Override
  public String toString() {
    return "Student{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", email='"
        + email
        + '\''
        + ", dayOfMonth="
        + dayOfMonth
        + ", age="
        + age
        + '}';
  }
}
