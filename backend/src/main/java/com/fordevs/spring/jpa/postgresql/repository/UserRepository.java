package com.fordevs.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fordevs.spring.jpa.postgresql.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByFullNameContaining(String fullName);
}
