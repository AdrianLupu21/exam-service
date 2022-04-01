package com.exam.examservice.repository;

import com.exam.examservice.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubjectRepo extends JpaRepository<Subject, Integer> {

    List<Subject> getSubjectsByName(String name);
}
