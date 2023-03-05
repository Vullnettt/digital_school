package com.zerogravitysolutions.subjectservice.subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    SubjectDto save(SubjectDto subjectDto);
    List<SubjectDto> findAll();
    Optional<SubjectDto> findById(Long id);
}
