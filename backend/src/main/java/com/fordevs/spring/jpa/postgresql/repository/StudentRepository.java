package com.fordevs.spring.jpa.postgresql.repository;

import java.util.List;

import com.fordevs.spring.jpa.postgresql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository< Student, Long> {
  List<Student> findByFullNameContaining(String fullName);


}
