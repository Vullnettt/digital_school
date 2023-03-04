package com.zerogravitysolutuins.instructor_service.instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {

    InstructorDto save(InstructorDto instructorDto);
    List<InstructorDto> findAll();
    Optional<InstructorDto> findById(Long id);
    InstructorDto update(InstructorDto instructorDto);

}
