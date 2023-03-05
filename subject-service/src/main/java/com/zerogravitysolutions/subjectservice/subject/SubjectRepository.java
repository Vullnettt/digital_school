package com.zerogravitysolutions.subjectservice.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("Select s From Subject As s  Where s.deletedAt <> null")
    Subject findDisableSubject();

    @Query("Select s From Subject As s  Where s.deletedAt = null")
    List<Subject> findAllSubject();

    @Query("Select s From Subject As s Where s.deletedAt = null And s.id = ?1")
    Optional<Subject> findSubjectById(Long id);
}
