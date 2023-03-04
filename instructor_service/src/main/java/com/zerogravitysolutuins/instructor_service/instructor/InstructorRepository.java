package com.zerogravitysolutuins.instructor_service.instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query("Select i From Instructor As i Where i.deletedAt <> null")
    Instructor getDisabledInstructor();

    @Query("Select i From Instructor As i Where i.deletedAt = null")
    List<Instructor> findAllInstructor();

    @Query("Select i From Instructor As i Where i.deletedAt = null And i.id = ?1")
    Optional<Instructor> findInstructorById(Long id);
}
