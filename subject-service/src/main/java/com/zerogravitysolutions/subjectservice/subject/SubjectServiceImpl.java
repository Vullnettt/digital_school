package com.zerogravitysolutions.subjectservice.subject;

import com.zerogravitysolutions.subjectservice.subject.utils.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject = new Subject();
        SubjectMapper.mapDtoToEntity(subjectDto, subject);
        subject.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        subject.setCreatedBy(1L);
        return SubjectMapper.mapEntityToDto(subjectRepository.save(subject));
    }

    @Override
    public List<SubjectDto> findAll() {
        List<Subject> subjects = subjectRepository.findAllSubject();
        return subjects.stream().map(subject -> SubjectMapper.mapEntityToDto(subject)).toList();
    }

    @Override
    public Optional<SubjectDto> findById(Long id) {
        Optional<Subject> subject = subjectRepository.findSubjectById(id);
        if(subject.isPresent()) {
            return Optional.of(SubjectMapper.mapEntityToDto(subject.get()));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject with id: " + subject.get().getId() + " not found.");
        }
    }
}
