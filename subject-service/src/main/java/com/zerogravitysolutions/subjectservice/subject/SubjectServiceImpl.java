package com.zerogravitysolutions.subjectservice.subject;

import com.zerogravitysolutions.subjectservice.subject.utils.SubjectMapper;
import com.zerogravitysolutions.subjectservice.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository,
                              RestTemplate restTemplate) {
        this.subjectRepository = subjectRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
         Subject subject = new Subject();
         Training training = restTemplate.getForObject("http://localhost:8081/trainings/" + subjectDto.getTrainingId()  , Training.class);
         SubjectMapper.mapDtoToEntity(subjectDto, subject);
         subject.setTraining(training);
         subject.setCreatedAt(new Timestamp(System.currentTimeMillis()));
         subject.setCreatedBy(1L);

//        trainingRepository.save(training);
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

    @Override
    public SubjectDto update(SubjectDto subjectDto) {
        Subject subject = new Subject();
        SubjectMapper.mapDtoToEntity(subjectDto, subject);
        subject.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        subject.setUpdatedBy(1L);
        return SubjectMapper.mapEntityToDto(subjectRepository.save(subject));
    }

    @Override
    public SubjectDto disable(Long id) {
        Optional<Subject> subject = subjectRepository.findSubjectById(id);
        subject.get().setDeletedAt(new Timestamp(System.currentTimeMillis()));
        subject.get().setDeletedBy(1L);
        subjectRepository.save(subject.get());
        return SubjectMapper.mapEntityToDto(subjectRepository.findDisableSubject());
    }

    @Override
    public SubjectDto partialUpdate(Long id, SubjectDto subjectDto) {
        Optional<Subject> subject = subjectRepository.findSubjectById(id);
        if(subject.isPresent()){
            SubjectMapper.mapDtoToEntity(subjectDto, subject.get());
            subject.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            subject.get().setUpdatedBy(1L);
            return SubjectMapper.mapEntityToDto(subjectRepository.save(subject.get()));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject with id: " + subject.get().getId() + " not found.");
        }
    }
}
