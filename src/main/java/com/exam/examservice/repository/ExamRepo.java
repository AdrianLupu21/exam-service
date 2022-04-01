package com.exam.examservice.repository;

import com.exam.examservice.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepo extends JpaRepository<Exam, Integer> {
}
