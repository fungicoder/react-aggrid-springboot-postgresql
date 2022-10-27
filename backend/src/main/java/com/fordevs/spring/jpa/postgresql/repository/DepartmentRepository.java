package com.fordevs.spring.jpa.postgresql.repository;

import com.fordevs.spring.jpa.postgresql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByDeptName(String deptName);
}
