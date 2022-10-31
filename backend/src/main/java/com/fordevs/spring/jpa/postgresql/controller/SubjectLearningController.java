package com.fordevs.spring.jpa.postgresql.controller;

import com.fordevs.spring.jpa.postgresql.model.SubjectLearnig;
import com.fordevs.spring.jpa.postgresql.repository.SubjectLearningRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectLearningController {

    @Autowired
    private SubjectLearningRepository subjectLearningRepository;

    public SubjectLearnig save(SubjectLearnig subjectLearnig){
        return subjectLearningRepository.save(subjectLearnig);
    }
}
