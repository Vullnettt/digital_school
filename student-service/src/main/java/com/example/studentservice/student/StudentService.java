package com.example.studentservice.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    List<StudentDto> findAll();
    Optional<StudentDto> findById(Long id);
    StudentDto update(StudentDto studentDto);
    StudentDto disable(Long id);
    StudentDto partialUpdate(Long id, StudentDto studentDto);
    StudentDto addStudentToGroup(Long studentId, Long groupId);
}
