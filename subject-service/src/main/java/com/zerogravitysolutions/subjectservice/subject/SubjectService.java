package com.zerogravitysolutions.subjectservice.subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    SubjectDto save(SubjectDto subjectDto);
    List<SubjectDto> findAll();
    Optional<SubjectDto> findById(Long id);
    SubjectDto update(SubjectDto subjectDto);
    SubjectDto disable(Long id);
    SubjectDto partialUpdate(Long id, SubjectDto subjectDto);
}
