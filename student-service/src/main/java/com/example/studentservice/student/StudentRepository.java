package com.example.studentservice.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s From Student As s  Where s.deletedAt = null")
    List<Student> findAllSubject();

    @Query("Select s From Student As s Where s.deletedAt = null And s.id = ?1")
    Optional<Student> findSubjectById(Long id);
}
