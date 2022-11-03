package com.fordevs.spring.jpa.postgresql.repository;

import com.fordevs.spring.jpa.postgresql.model.SubjectLearning;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectLearningRepository extends JpaRepository<SubjectLearning, Long> {
    List<SubjectLearning> findBySubjectLearningNameContaining(String subjectLearningName);
}
